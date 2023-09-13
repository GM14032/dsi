package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import com.restaurante.dsi.model.businesslogic.DiningTable;
import com.restaurante.dsi.model.businesslogic.Product;

public interface IProductService {
  public List<Product> findAll();
  public Product save(Product product);
  public Product update(Product currentProduct, Product product);
  public Product findById(Long id);
  public void delete(Long id);
}
