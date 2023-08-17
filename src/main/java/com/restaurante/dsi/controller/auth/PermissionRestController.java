package com.restaurante.dsi.controller.auth;

import com.restaurante.dsi.model.auth.Permission;
import com.restaurante.dsi.service.auth.IPermissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/permissions")
@Tag(name = "Permisos", description = "Endpoints para los permisos")
public class PermissionRestController {
    @Autowired
    private IPermissionService permissionService;

    @GetMapping({ "/", "" })
    public List<Permission> index() {
        return permissionService.findAll();
    }
}
