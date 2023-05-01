package com.restaurante.dsi.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.restaurante.dsi.security.JwtUtils;
import com.restaurante.dsi.utils.AuthRequest;

@RestController
@RequestMapping("/auth/token")
@CrossOrigin(origins = {"*"})
public class AuthController {

  @Autowired
  private JwtUtils jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/")
  public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    if (authentication.isAuthenticated()) {
      Map<String, String> response = new HashMap();
      response.put("accessToken", jwtService.generateJwtToken(authentication));
      return new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);
    } else {
      throw new UsernameNotFoundException("invalid user request !");
    }

  }
}
