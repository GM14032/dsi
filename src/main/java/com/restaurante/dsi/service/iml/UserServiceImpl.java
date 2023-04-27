package com.restaurante.dsi.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.Users;
import com.restaurante.dsi.repository.IUsers;
import com.restaurante.dsi.service.IUserService;
import com.restaurante.dsi.utils.UserDetailsImpl;

@Service("UserService")
public class UserServiceImpl implements IUserService, UserDetailsService {

  @Autowired
  private IUsers usersRepository;

  @Override
  public List<Users> findAll() {
    return usersRepository.findAll();
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    Users user = usersRepository.findByUsername(username);

    return UserDetailsImpl.build(user);
  }

  @Override
  public Users save(Users user) {
    return usersRepository.save(user);
  }

}
