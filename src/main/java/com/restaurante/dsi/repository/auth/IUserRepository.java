package com.restaurante.dsi.repository.auth;

import com.restaurante.dsi.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  public User findByUsernameAndEnableTrue(String username);
  public User findByEmail(String email);
  @Query("SELECT u FROM User u WHERE u.role.name = ?1")
  public List<User> findByRole(String role);
}
