package com.restaurante.dsi.service.iml;

import com.restaurante.dsi.middlewares.CustomExceptionHandler;
import com.restaurante.dsi.model.Permission;
import com.restaurante.dsi.model.Role;
import com.restaurante.dsi.repository.IRoleRepository;
import com.restaurante.dsi.service.IRoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("RoleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role save(Role role) {
        try {
            return roleRepository.save(role);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomExceptionHandler.DataIntegrityException("Ya existe un rol con ese nombre.");
        }

    }

    @Override
    @Transactional
    public Role update(Role currentRole, Role role) {
        try {
            if(role.getName()!=null){
                currentRole.setName(role.getName());
            }
            if(role.getDescription()!=null){
                currentRole.setDescription(role.getDescription());
            }
            if (role.getEnable() != null) {
                currentRole.setEnable(role.getEnable());
            }
            if(role.getPermissions().size()>0){
                currentRole.setPermissions(role.getPermissions());
            }
            return roleRepository.save(currentRole);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomExceptionHandler.DataIntegrityException("Ya existe un usuario con ese username.");
        }

    }

    @Override
    public Role findById(Long id) {

        return roleRepository.findById(id).orElse(null);
    }
}
