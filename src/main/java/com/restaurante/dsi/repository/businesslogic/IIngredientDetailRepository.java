package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.IngredientDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientDetailRepository extends JpaRepository<IngredientDetail, Long> {
}
