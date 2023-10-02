package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.IngredientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IIngredientDetailRepository extends JpaRepository<IngredientDetail, Long> {
}
