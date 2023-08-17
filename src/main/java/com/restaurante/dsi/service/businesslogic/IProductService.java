package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import com.restaurante.dsi.model.businesslogic.Product;

public interface IProductService {
  public List<Product> findAll();
}
