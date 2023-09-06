package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Ingredient;

import java.util.List;

public interface IIngredientService {
    public List<Ingredient> findAll();
    Ingredient save(Ingredient ingredient);
    Ingredient update(Ingredient currentIngredient,Ingredient ingredient);
    Ingredient findById(Long id);
}
