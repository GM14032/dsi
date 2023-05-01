package com.restaurante.dsi.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.restaurante.dsi.model.User;
import com.restaurante.dsi.service.IUserService;

@CrossOrigin(origins = {"*"})
@Validated @RestController
@RequestMapping("/api/users")
public class UserRestController {
  @Autowired
  private IUserService userService;
  @GetMapping({ "/", "" })
  public List<User> index() {
    return userService.findAll();
  }
  @PostMapping("/register")
  public User register(@RequestBody @Valid User user) {
    BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
    user.setPassword(pass.encode(user.getPassword()));
    return userService.save(user);
  }
  @PutMapping("/update")
  public User update(@RequestBody @Valid User user) {
    BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
    user.setPassword(pass.encode(user.getPassword()));
        return userService.update(user);
  }
  @GetMapping("/find/{id}")
  public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }
  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
  @GetMapping("/auth")
  @PreAuthorize("isAuthenticated()")
  public List<User> authorize() {
    return userService.findAll();
  }

  @GetMapping("/role")
  @PreAuthorize("hasPermission(#user, 'READ_USER')")
  public List<User> testAdmin() {
    return userService.findAll();
  }
}
