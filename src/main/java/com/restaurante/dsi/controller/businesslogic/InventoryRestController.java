package com.restaurante.dsi.controller.businesslogic;

import com.restaurante.dsi.model.businesslogic.Inventory;
import com.restaurante.dsi.service.businesslogic.IInventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Inventario", description = "Endpoints para la gestion de inventario")
public class InventoryRestController {
    @Autowired
    private IInventoryService inventoryService;
    @GetMapping({ "/", "" })
    public List<Inventory> getAll(@RequestParam(required = false) Boolean active) {
        return inventoryService.findAll(active);
    }
    @PostMapping({ "/", "" })
    public Inventory register(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }
    @PutMapping("/{id}")
    public Inventory update(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory currInventory = inventoryService.findById(id);
        return inventoryService.update(currInventory, inventory);
    }
    @GetMapping("/{id}")
    public Inventory show(@PathVariable Long id) {
        return inventoryService.findById(id);
    }
}
