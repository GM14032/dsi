package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Setter @Getter @NoArgsConstructor
public class Category {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
}
