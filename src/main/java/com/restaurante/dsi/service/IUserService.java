package com.restaurante.dsi.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.restaurante.dsi.model.Users;

public interface IUserService {
  public List<Users> findAll();

  public UserDetails loadUserByUsername(String username);

  public Users save(Users user);
}
