package com.restaurante.dsi.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurante.dsi.model.auth.Permission;
import com.restaurante.dsi.model.auth.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

  private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String name;
  private String lastName;
  private String role;
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String username, String name, String password,String lastName,String role,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;

    this.password = password;
    this.authorities = authorities;
    this.name = name;
    this.lastName = lastName;
    this.role = role;
  }

  public static UserDetailsImpl build(User user) {
    Set<Permission> permissions = new HashSet();
    if (user.getRole() != null) {
      permissions = user.getRole().getPermissions();
    }
    List<GrantedAuthority> authorities = permissions.stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getName()))
        .collect(Collectors.toList());

    logger.info("Authorities: {}", authorities);
    return new UserDetailsImpl(
        user.getId(),
        user.getUsername(),
        user.getName(),
        user.getPassword(),
        user.getLastname(),
        user.getRole().getName(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }

}
