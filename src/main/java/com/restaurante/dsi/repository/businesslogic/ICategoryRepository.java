package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
