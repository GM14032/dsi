package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.dsi.model.auth.User;
import lombok.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Setter @Getter @NoArgsConstructor
@Table(name = "tables")
public class DiningTable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long capacity;
    private String description;
    @Column(columnDefinition = "boolean default true")
    private Boolean available=true;

    @OneToMany(mappedBy = "table", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();
}
