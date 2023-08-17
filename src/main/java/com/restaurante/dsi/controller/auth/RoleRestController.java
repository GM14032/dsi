package com.restaurante.dsi.controller.auth;

import com.restaurante.dsi.model.auth.Role;
import com.restaurante.dsi.service.auth.IPermissionService;
import com.restaurante.dsi.service.auth.IRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = {"*"})
@RestController @Validated
@RequestMapping("/api/roles")
@Tag(name = "Roles", description = "Endpoints para los roles")
public class RoleRestController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @GetMapping({ "/", "" })
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PostMapping("/")
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
    public ResponseEntity<Role>  getRoleById(@PathVariable Long id) {
        Role role= roleService.findById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
