package com.restaurante.dsi.service.auth;

import com.restaurante.dsi.model.auth.Role;
import java.util.List;

public interface IRoleService {
    public List<Role> findAll();
    public Role save(Role role);
    public Role update(Role currentRole,Role role);
    public Role findById(Long id);
}
