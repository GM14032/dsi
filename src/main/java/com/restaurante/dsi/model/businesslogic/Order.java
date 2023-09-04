package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Order {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_order")
    private Long numberOrder;
    // TODO: change for a foreign key of categories (desayuno, almuerzo, cena,
    // bebidas, etc)
    private String category;

    private Integer quantity;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private OrderState state;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "order" })
    private List<OrderDetail> orderDetails;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_id")
    @JsonIgnoreProperties({"orders"})
    private DiningTable table;

    private Double total = 0.0;
    @JsonProperty("create_at")
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    @JsonProperty("update_at")
    private LocalDateTime updateAt;
    @PrePersist
    public void prePersist() {
        createAt = LocalDateTime.now();}
    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }


}
