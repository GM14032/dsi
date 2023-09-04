package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.dsi.model.auth.User;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

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

    @ManyToOne
    @JsonIgnoreProperties({"tables"})
    private Order orders;

}
