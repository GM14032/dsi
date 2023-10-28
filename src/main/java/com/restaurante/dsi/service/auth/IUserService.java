package com.restaurante.dsi.service.auth;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.restaurante.dsi.model.auth.User;

public interface IUserService {
  public List<User> findAll();
  public UserDetails loadUserByUsername(String username);
  public User save(User user);
  public User update(User currentUser,User user);
  public User findById(Long id);

  public void delete(Long id);

  public User findByEmail(String email);
  public List<User> findByRole(String role);
}
