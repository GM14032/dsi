package com.restaurante.dsi.service.auth;

import com.restaurante.dsi.model.auth.Permission;
import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();
    public Permission findById(Long id);
}
