package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "order_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
@NoArgsConstructor
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double total = 0.0;
  private Integer quantity;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id")
  private Order order;

  private static final long serialVersionUID = 1L;
}
