package com.restaurante.dsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dsi.model.Users;
import com.restaurante.dsi.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

  @Autowired
  private IUserService userService;

  @GetMapping({ "/", "" })
  public List<Users> index() {
    return userService.findAll();
  }

  @PostMapping("/register")
  public Users register(@RequestBody Users user) {
    BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
    user.setPassword(pass.encode(user.getPassword()));
    return userService.save(user);
  }

  @GetMapping("/auth")
  @PreAuthorize("isAuthenticated()")
  public List<Users> authorize() {
    return userService.findAll();
  }

  @GetMapping("/role")
  @PreAuthorize("hasPermission(#user, 'READ_USER')")
  public List<Users> testAdmin() {
    return userService.findAll();
  }
}
