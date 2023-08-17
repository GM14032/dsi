package com.restaurante.dsi.service.auth;

import com.restaurante.dsi.model.auth.Permission;
import com.restaurante.dsi.repository.auth.IPermissionRepository;
import com.restaurante.dsi.service.auth.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PermissionService")
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionRepository permissionRepository;
    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
    @Override
public Permission findById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }
}
