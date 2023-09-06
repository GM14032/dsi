package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
@NoArgsConstructor
public class InventoryDetail {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double quantity;
    private Double price;
    private Boolean isEntry;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    @JsonIgnoreProperties({"inventoryDetails"})
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @JsonIgnoreProperties({"inventoryDetails"})
    private Ingredient ingredient;

    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist() {
        createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }
}
