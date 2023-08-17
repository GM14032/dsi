package com.restaurante.dsi.controller.businesslogic;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.restaurante.dsi.model.businesslogic.DiningTable;
import com.restaurante.dsi.service.businesslogic.IDiningTableService;
import jakarta.validation.Valid;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/table")
@Tag(name = "Mesas", description = "Endpoints para las mesas")
public class DiningTableRestController {
@Autowired
private IDiningTableService tableService;
@GetMapping({ "/", "" })
 public List<DiningTable> listar(){
    return tableService.findAll();
 }
  @PostMapping("/")
  public DiningTable create(@RequestBody @Valid DiningTable table) {
    return tableService.save(table);
  }
  @PutMapping("/{id}")
  public DiningTable update(@PathVariable Long id, @RequestBody DiningTable table) {
       DiningTable currTable=tableService.findById(id);
    return tableService.update(currTable,table);
  }
  @GetMapping("/{id}")
  public ResponseEntity<DiningTable> getMesaById(@PathVariable Long id) {
        DiningTable table = tableService.findById(id);
        if (table != null) {
          return ResponseEntity.ok(table);
        } else {
          return ResponseEntity.notFound().build();
        }
    }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
        tableService.delete(id);
    }
}