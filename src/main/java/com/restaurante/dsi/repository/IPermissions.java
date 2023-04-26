package com.restaurante.dsi.repository;

import com.restaurante.dsi.model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissions extends JpaRepository<Permissions, Long> {
}
