package com.restaurante.dsi.controller.businesslogic;

import com.restaurante.dsi.model.businesslogic.Ingredient;
import com.restaurante.dsi.service.businesslogic.IIngredientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/ingredients")
@Tag(name = "Ingredientes", description = "Endpoints para los ingredientes")
public class IngredientRestController {
    @Autowired
    private IIngredientService ingredientService;
    @GetMapping({ "/", "" })
    public List<Ingredient> getAll() {
        return ingredientService.findAll();
    }
    @PostMapping({ "/", "" })
    public Ingredient register(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }
    @PutMapping("/{id}")
    public Ingredient update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        Ingredient currIngredient = ingredientService.findById(id);
        return ingredientService.update(currIngredient, ingredient);
    }
    @GetMapping("/{id}")
    public Ingredient show(@PathVariable Long id) {
        return ingredientService.findById(id);
    }
}
