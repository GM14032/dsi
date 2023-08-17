package com.restaurante.dsi.repository.businesslogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.dsi.model.businesslogic.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
