package com.restaurante.dsi.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.restaurante.dsi.model.User;

public interface IUserService {
  public List<User> findAll();
  public UserDetails loadUserByUsername(String username);
  public User save(User user);
  public User update(User currentUser,User user);
  public User findById(Long id);

  public void delete(Long id);

  public User findByEmail(String email);
}
