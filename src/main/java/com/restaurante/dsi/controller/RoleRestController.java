package com.restaurante.dsi.controller;

import com.restaurante.dsi.model.Permission;
import com.restaurante.dsi.model.Role;
import com.restaurante.dsi.service.IPermissionService;
import com.restaurante.dsi.service.IRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.http.*;
@CrossOrigin(origins = {"*"})
@RestController @Validated
@RequestMapping("/api/roles")
public class RoleRestController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;


    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping("/create")
    public Role createRole(@RequestBody @Valid Role role) {
        return roleService.save(role);
    }
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id,@RequestBody @Valid Role role) {
        Role roleToSaved = roleService.findById(id);
        if(roleToSaved == null) {
                return null;
        }
        return roleService.update(roleToSaved,role);
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }
}
