package com.restaurante.dsi.repository.auth;

import com.restaurante.dsi.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  public User findByUsernameAndEnableTrue(String username);
  public User findByEmail(String email);
}
