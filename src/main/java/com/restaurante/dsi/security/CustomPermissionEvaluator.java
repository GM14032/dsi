package com.restaurante.dsi.security;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
  private static final Logger logger = LoggerFactory.getLogger(CustomPermissionEvaluator.class);

  @Override
  public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    logger.info(permission + ": Authorities = " + authentication.getAuthorities());
    for (GrantedAuthority authority : authentication.getAuthorities()) {
      if (authority.getAuthority().equals(permission)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
      Object permission) {
    return false;
  }
}
