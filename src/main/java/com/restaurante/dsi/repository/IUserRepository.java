package com.restaurante.dsi.repository;

import com.restaurante.dsi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  public User findByUsername(String username);
}
