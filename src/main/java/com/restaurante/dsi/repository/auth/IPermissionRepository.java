package com.restaurante.dsi.repository.auth;

import com.restaurante.dsi.model.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long>{
}
