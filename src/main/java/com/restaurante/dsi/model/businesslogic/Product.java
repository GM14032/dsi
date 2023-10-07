package com.restaurante.dsi.model.businesslogic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Table(name = "products")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity @Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Product{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  private Double price;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonIgnoreProperties({ "product" })
  private List<IngredientDetail> ingredientDetails;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "category_id")
  @JsonIgnoreProperties({"products"})
  private Category category;
}
