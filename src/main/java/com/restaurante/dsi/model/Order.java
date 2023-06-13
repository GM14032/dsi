package com.restaurante.dsi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter@NoArgsConstructor
public class Order {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_order")
    private Long numberOrder;
    private String category;
    private Integer quantity;
    private String description;
    private Long state;
    private String name;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        updateAt = new Date();
    }

}
