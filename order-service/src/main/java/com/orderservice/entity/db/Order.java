package com.orderservice.entity.db;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"orderId"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  private Timestamp orderTime;

  @ManyToMany(mappedBy = "orders", cascade = CascadeType.PERSIST)
  private List<Item> items = new ArrayList<>();
}
