package com.restaurante.dsi.controller.businesslogic;

import com.restaurante.dsi.model.businesslogic.InventoryDetail;
import com.restaurante.dsi.service.businesslogic.IInventoryDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/inventorydetails")
@Tag(name = "Detalle de inventario", description = "Endpoints para los detalles de inventario")
public class InventoryDetailRestController {
    @Autowired
    private IInventoryDetailService inventoryDetailService;
    @GetMapping({ "/", "" })
    public List<InventoryDetail> getAll() {
        return inventoryDetailService.getAll();
    }
    @PostMapping({ "/", "" })
    public InventoryDetail register(@RequestBody InventoryDetail inventoryDetail) {
        return inventoryDetailService.save(inventoryDetail);
    }
    @PutMapping("/{id}")
    public InventoryDetail update(@PathVariable Long id, @RequestBody InventoryDetail inventoryDetail) {
        InventoryDetail currInventoryDetail = inventoryDetailService.findById(id);
        return inventoryDetailService.update(currInventoryDetail, inventoryDetail);
    }
    @GetMapping("/{id}")
    public List<InventoryDetail> show(@PathVariable Long id) {
        return inventoryDetailService.findByInventory(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventoryDetailService.delete(id);
    }
}
