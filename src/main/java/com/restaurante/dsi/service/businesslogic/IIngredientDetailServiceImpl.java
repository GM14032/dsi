package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.IngredientDetail;
import com.restaurante.dsi.repository.businesslogic.IIngredientDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIngredientDetailServiceImpl implements IIngredientDetailService{
    @Autowired
    private IIngredientDetailRepository ingredientDetailRepository;


    @Override
    public List<IngredientDetail> findAll() {
        return ingredientDetailRepository.findAll();
    }

    @Override
    public IngredientDetail save(IngredientDetail ingredientDetail) {
        return ingredientDetailRepository.save(ingredientDetail);
    }

    @Override
    public IngredientDetail update(IngredientDetail currentIngredientDetail, IngredientDetail ingredientDetail) {
        if (ingredientDetail.getQuantity() != null) {
            currentIngredientDetail.setQuantity(ingredientDetail.getQuantity());
        }
        if (ingredientDetail.getProduct() != null) {
            currentIngredientDetail.setProduct(ingredientDetail.getProduct());
        }
        if (ingredientDetail.getIngredient() != null) {
            currentIngredientDetail.setIngredient(ingredientDetail.getIngredient());
        }
        return ingredientDetailRepository.save(currentIngredientDetail);
    }

    @Override
    public IngredientDetail findById(Long id) {
        return ingredientDetailRepository.findById(id).orElse(null);
    }
}
