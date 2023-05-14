package com.restaurante.dsi.service.iml;

import com.restaurante.dsi.model.Permission;
import com.restaurante.dsi.repository.IPermissionRepository;
import com.restaurante.dsi.service.IPermissionService;
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
