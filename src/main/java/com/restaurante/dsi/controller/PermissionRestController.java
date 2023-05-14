package com.restaurante.dsi.controller;

import com.restaurante.dsi.model.Permission;
import com.restaurante.dsi.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/permissions")
public class PermissionRestController {
    @Autowired
    private IPermissionService permissionService;

    @GetMapping({ "/", "" })
    public List<Permission> index() {
        return permissionService.findAll();
    }
}
