package com.restaurante.dsi.controller;

import java.util.List;

import com.restaurante.dsi.middlewares.CustomExceptionHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  @PostMapping("/")
  public User register(@RequestBody @Valid User user) {
    BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
    user.setPassword(pass.encode(user.getPassword()));
    return userService.save(user);
  }
  @PutMapping("/{id}")
  public User update(@PathVariable Long id, @RequestBody User user) {
    if(user.getPassword()!=null){
      BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
      user.setPassword(pass.encode(user.getPassword()));
    }
     User currUser=userService.findById(id);
    return userService.update(currUser,user);
  }
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
          return ResponseEntity.ok(user);
        } else {
          return ResponseEntity.notFound().build();
        }


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
