package com.restaurante.dsi.controller.businesslogic;

import java.util.List;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dsi.model.businesslogic.DiningTable;
import com.restaurante.dsi.model.businesslogic.Product;
import com.restaurante.dsi.service.businesslogic.IProductService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/products")
@Tag(name = "Productos", description = "Endpoints para los productos")
public class ProductController {

  @Autowired
  private IProductService productService;

  @GetMapping({ "/", "" })
 public List<Product> index(){
    return productService.findAll();
 }
   @PostMapping("/")
  public Product create(@RequestBody @Valid Product product) {
    return productService.save(product);
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Long id, @RequestBody Product product) {
       Product cuProduct=productService.findById(id);
    return productService.update(cuProduct,product);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Product> getMesaById(@PathVariable Long id) {
        Product cproduct = productService.findById(id);
        if (cproduct != null) {
          return ResponseEntity.ok(cproduct);
        } else {
          return ResponseEntity.notFound().build();
        }
    }

}
