package com.restaurante.dsi.controller;

import com.restaurante.dsi.model.Role;
import com.restaurante.dsi.service.IRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Validated
@RequestMapping("/api/roles")
public class RoleRestController {
    @Autowired
    private IRoleService roleService;
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping("/create")
    public Role createRole(@RequestBody @Valid Role role) {
        return roleService.save(role);
    }
    @PutMapping("/")
    public Role updateRole(Role role) {
        return roleService.update(role);
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.findById(id).orElse(null);
    }
}
