package com.restaurante.dsi.repository;

import com.restaurante.dsi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsers extends JpaRepository<Users, Long> {
}
