package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
@NoArgsConstructor
public class Ingredient {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean isCountable;
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private Set<InventoryDetail> inventoryDetails;
    @PrePersist
    public void prePersist() {
        createAt = LocalDateTime.now();}
    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }
}
