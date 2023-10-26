package com.restaurante.dsi.controller.businesslogic;

import com.restaurante.dsi.model.businesslogic.Category;
import com.restaurante.dsi.repository.businesslogic.ICategoryRepository;
import com.restaurante.dsi.service.businesslogic.ICategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/category")
@Tag(name = "Categorias", description = "Endpoints para las categorias")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping({"/", ""})
    public List<Category> getAll() {
        return categoryService.findAll();
    }
}