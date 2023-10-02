package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.IngredientDetail;

import java.util.List;

public interface IIngredientDetailService {
    public List<IngredientDetail> findAll();
    public IngredientDetail save(IngredientDetail ingredientDetail);
    public IngredientDetail update(IngredientDetail currentIngredientDetail, IngredientDetail ingredientDetail);
    public IngredientDetail findById(Long id);
    public void delete(Long id);
}
