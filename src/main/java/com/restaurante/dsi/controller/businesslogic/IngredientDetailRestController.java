package com.restaurante.dsi.controller.businesslogic;

import com.restaurante.dsi.model.businesslogic.IngredientDetail;
import com.restaurante.dsi.service.businesslogic.IIngredientDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/ingredientdetails")
@Tag(name = "Ingredientes", description = "Endpoints para los ingredientes")
public class IngredientDetailRestController {
    @Autowired
    private IIngredientDetailService ingredientDetailService;
    @GetMapping({ "/", "" })
    public List<IngredientDetail> getAll() {
        return ingredientDetailService.findAll();
    }
    @PostMapping({ "/", "" })
    public IngredientDetail register(@RequestBody IngredientDetail ingredientDetail) {
        return ingredientDetailService.save(ingredientDetail);
    }
    @PutMapping("/{id}")
    public IngredientDetail update(@PathVariable Long id, @RequestBody IngredientDetail ingredientDetail) {
        IngredientDetail currIngredientDetail = ingredientDetailService.findById(id);
        return ingredientDetailService.update(currIngredientDetail, ingredientDetail);
    }
    @GetMapping("/{id}")
    public IngredientDetail show(@PathVariable Long id) {
        return ingredientDetailService.findById(id);
    }
}
