package com.restaurante.dsi.controller.businesslogic;

import com.itextpdf.text.DocumentException;
import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.businesslogic.Inventory;
import com.restaurante.dsi.model.businesslogic.InventoryDetailDto;
import com.restaurante.dsi.model.businesslogic.InventoryDto;
import com.restaurante.dsi.service.auth.IUserService;
import com.restaurante.dsi.service.businesslogic.IInventoryDetailService;
import com.restaurante.dsi.service.businesslogic.IInventoryService;
import com.restaurante.dsi.utils.PdfGenerator;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Inventario", description = "Endpoints para la gestion de inventario")
public class InventoryRestController {
    @Autowired
    private IInventoryService inventoryService;
    @Autowired
    private IInventoryDetailService inventoryDetailService;
    @Autowired
    private IUserService usuarioService;
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

    @GetMapping("/report")
    public void sendInventoryReport() throws MessagingException {
        PdfGenerator pdfGenerator = new PdfGenerator();
        Inventory inventory = inventoryService.findAll(true).get(0);
        List<InventoryDetailDto> inventoryDetailDto = inventoryDetailService.getInventoryDetail(inventory.getId());
        List<InventoryDto> inventoryDto = inventoryService.getInventoryReport();
        byte[] pdfBytes = null;
        try {
            pdfBytes = pdfGenerator.generatePdf(inventoryDto,inventoryDetailDto);

                    } catch (IOException | DocumentException e) {
                 e.printStackTrace();
        }
        List<User> users= usuarioService.findByRole("Admin");
        inventoryService.sendInventoryReport(pdfBytes,users);
    }
}
