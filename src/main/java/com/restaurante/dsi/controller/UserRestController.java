package com.restaurante.dsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dsi.model.Users;
import com.restaurante.dsi.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

  @Autowired
  private IUserService userService;
  
  @GetMapping({"/", ""})
  public List<Users> index() {
    return userService.findAll();
  }

  @GetMapping("/auth")
  @PreAuthorize("hasPrivilege('ADMIN')")
  public List<Users> authorize() {
    return userService.findAll();
  }
}
