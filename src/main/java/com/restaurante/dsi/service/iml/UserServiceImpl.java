package com.restaurante.dsi.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.Users;
import com.restaurante.dsi.repository.IUsers;
import com.restaurante.dsi.service.IUserService;

@Service("UserService")
public class UserServiceImpl implements IUserService {
  
  @Autowired
  private IUsers usersRepository;

  @Override
  public List<Users> findAll() {
    return usersRepository.findAll();
  }
  
}
