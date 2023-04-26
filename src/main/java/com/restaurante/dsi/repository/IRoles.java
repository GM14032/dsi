package com.restaurante.dsi.repository;

import com.restaurante.dsi.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoles extends JpaRepository<Roles , Long> {
}
