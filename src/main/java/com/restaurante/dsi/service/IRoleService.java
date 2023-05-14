package com.restaurante.dsi.service;

import com.restaurante.dsi.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    public List<Role> findAll();
    public Role save(Role role);
    public Role update(Role currentRole,Role role);
    public Role findById(Long id);
}
