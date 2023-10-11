package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Category;
import com.restaurante.dsi.repository.businesslogic.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
