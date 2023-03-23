package com.orderservice.service.impl;

import com.orderservice.entity.db.Item;
import com.orderservice.entity.db.Order;
import com.orderservice.entity.dto.InventoryDto;
import com.orderservice.entity.dto.OrderDto;
import com.orderservice.entity.dto.OrderPostDto;
import com.orderservice.entity.mapper.OrderMapper;
import com.orderservice.event.OrderEvent;
import com.orderservice.repository.ItemRepository;
import com.orderservice.repository.OrderRepository;
import com.orderservice.service.inter.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final ItemRepository itemRepository;
  private final WebClient.Builder webClientBuilder;
  private final KafkaTemplate<String, OrderEvent> kafkaTemplate;


  @Override
  @Transactional
  public OrderDto create(OrderPostDto orderPostDto) {
    List<Long> itemsIds = orderPostDto.getItemIds();
    List<Item> items = itemRepository.findAllById(itemsIds);
    List<String> names = items.stream().map(Item::getName).collect(Collectors.toList());
    Map<String, Integer> availability = new HashMap<>();
    Arrays.stream(
                    Objects.requireNonNull(
                            webClientBuilder
                                    .build()
                                    .get()
                                    .uri(
                                            "http://inventory-service/inventory",
                                            uriBuilder -> uriBuilder.queryParam("name", names).build())
                                    .retrieve()
                                    .bodyToMono(InventoryDto[].class)
                                    .block()))
            .forEach(item -> availability.put(item.getItemName(), item.getAmount()));
    for (Item value : items) {
      if (value.getAmount() > availability.get(value.getName()))
        throw new IllegalArgumentException("There is not enough items in the inventory");
    }
    Order order = OrderMapper.INSTANCE.fromPostDto(orderPostDto);
    items.forEach(item -> item.getOrders().add(order));
    order.setItems(items);
    Order savedOrder = orderRepository.save(order);
    kafkaTemplate.send("orderNotification", new OrderEvent(savedOrder.getOrderId()));
    return OrderMapper.INSTANCE.toDto(savedOrder);
  }

  @Override
  public List<OrderDto> findAll() {
    return orderRepository.findAll().stream()
        .map(OrderMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }
}
