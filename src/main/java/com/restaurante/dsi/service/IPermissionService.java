package com.restaurante.dsi.service;

import com.restaurante.dsi.model.Permission;
import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();
    public Permission findById(Long id);
}
