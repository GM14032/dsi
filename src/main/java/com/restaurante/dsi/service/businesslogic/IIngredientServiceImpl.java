package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Ingredient;
import com.restaurante.dsi.repository.businesslogic.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIngredientServiceImpl implements IIngredientService{
    @Autowired
    private IIngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient update(Ingredient currentIngredient, Ingredient ingredient) {
        if (ingredient.getName() != null) {
            currentIngredient.setName(ingredient.getName());
        }
        if (ingredient.getIsCountable() != null) {
            currentIngredient.setIsCountable(ingredient.getIsCountable());
        }
        if (ingredient.getDescription() != null) {
            currentIngredient.setDescription(ingredient.getDescription());
        }
        if (ingredient.getUnit() != null) {
            currentIngredient.setUnit(ingredient.getUnit());
        }
        return ingredientRepository.save(currentIngredient);
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
