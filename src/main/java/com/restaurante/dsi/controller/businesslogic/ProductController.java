package com.restaurante.dsi.controller.businesslogic;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public List<Product> index() {
    return productService.findAll();
  }

}
