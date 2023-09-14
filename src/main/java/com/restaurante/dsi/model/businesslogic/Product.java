package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "products")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
@NoArgsConstructor

public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  private Double price = 0.0;
  
  private static final long serialVersionUID = 1L;  

  @OneToMany(mappedBy = "product")
  @JsonIgnore
  private Set<IngredientDetail> ingredientDetails;
}
