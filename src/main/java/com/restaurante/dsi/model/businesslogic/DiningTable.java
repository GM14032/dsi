package com.restaurante.dsi.model.businesslogic;

import lombok.*;
import jakarta.persistence.*;

@Entity @Setter @Getter @NoArgsConstructor
@Table(name = "tables")
public class DiningTable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long capacity;
    private String description;

}
