package com.restaurante.dsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dsi.model.Product;
import com.restaurante.dsi.service.IProductService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private IProductService productService;

  @GetMapping({ "/", "" })
  public List<Product> index() {
    return productService.findAll();
  }

}
