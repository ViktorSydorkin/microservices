package com.orderservice.entity.db;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "amount")
    private int amount;
    @Column(name = "product_id")
    private Long productId;
    @ManyToMany
    @JoinTable(name = "orders_items",
            joinColumns = {@JoinColumn(name = "items_item_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_order_id")})
    private List<Order> orders = new ArrayList<>();
}
