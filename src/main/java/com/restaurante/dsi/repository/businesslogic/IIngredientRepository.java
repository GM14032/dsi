package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient,Long> {
}
