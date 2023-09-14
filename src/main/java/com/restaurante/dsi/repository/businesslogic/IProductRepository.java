package com.restaurante.dsi.repository.businesslogic;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurante.dsi.model.businesslogic.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{
}
