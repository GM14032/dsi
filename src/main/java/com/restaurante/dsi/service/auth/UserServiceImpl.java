package com.restaurante.dsi.service.auth;

import java.util.List;
import java.util.Optional;
import com.restaurante.dsi.middlewares.CustomExceptionHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.repository.auth.IUserRepository;
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
    User user = usersRepository.findByUsernameAndEnableTrue(username);
    return UserDetailsImpl.build(user);
  }

  @Override
  @Transactional
  public User save(User user) {
    try {
      return usersRepository.save(user);
    } catch (DataIntegrityViolationException ex) {
      throw new CustomExceptionHandler.DataIntegrityException("Ya existe un usuario con ese username.");
    }
  }

  @Override
  public User update(User currentUser,User user) {
    try {
      if( user.getName() != null ){
        currentUser.setName(user.getName());
      }
      if( user.getLastname() != null ){
        currentUser.setLastname(user.getLastname());
      }
      if (user.getUsername() != null) {
        currentUser.setUsername(user.getUsername());
      }
      if (user.getPassword() != null) {
        currentUser.setPassword(user.getPassword());
      }
      if( user.getRole() != null ){
        currentUser.setRole(user.getRole());
      }
      if (user.getEnable() != null) {
        currentUser.setEnable(user.getEnable());
      }
      if(user.getPhone()!=null){
        currentUser.setPhone(user.getPhone());
      }
      if(user.getEmail()!=null){
        currentUser.setEmail(user.getEmail());
      }
      return usersRepository.save(currentUser);
    } catch (DataIntegrityViolationException ex) {
      throw new CustomExceptionHandler.DataIntegrityException("Ya existe un usuario con ese username.");
    }

  }

  @Override
  public User findById(Long id) {
    return usersRepository.findById(id).orElse(null);
  }
  @Override
  public User findByEmail(String email) {
    return usersRepository.findByEmail(email);
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
