package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.businesslogic.Product;
import com.restaurante.dsi.repository.businesslogic.IProductRepository;
import com.restaurante.dsi.service.businesslogic.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private IProductRepository productRepository;

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }
}
