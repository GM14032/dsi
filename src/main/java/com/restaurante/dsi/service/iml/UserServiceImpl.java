package com.restaurante.dsi.service.iml;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.User;
import com.restaurante.dsi.repository.IUserRepository;
import com.restaurante.dsi.service.IUserService;
import com.restaurante.dsi.utils.UserDetailsImpl;

@Service("UserService")
public class UserServiceImpl implements IUserService, UserDetailsService {

  @Autowired
  private IUserRepository usersRepository;

  @Override
  public List<User> findAll() {
    return usersRepository.findAll();
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = usersRepository.findByUsername(username);

    return UserDetailsImpl.build(user);
  }

  @Override
  public User save(User user) {
    return usersRepository.save(user);
  }

  @Override
  public User update(User user) {
    return usersRepository.save(user);
  }

  @Override
  public User findById(Long id) {
    return usersRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Long id) {
    Optional<User> users = usersRepository.findById(id);
    if (users.isPresent()) {
      User user = users.get();
      user.setEnable(false);
      usersRepository.save(user);
    } else {
      throw new EntityNotFoundException("Object with id " + id + " not found");
    }
  }


}
