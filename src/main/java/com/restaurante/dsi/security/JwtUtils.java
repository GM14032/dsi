package com.restaurante.dsi.security;

import java.util.*;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.restaurante.dsi.utils.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	@Value("${dsi.jwtSecret}")
	private String jwtSecret;

	@Value("${dsi.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		SecretKeySpec secret_key = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
		Map<String, Object> claims = new HashMap<>();
		claims.put("username", userPrincipal.getUsername());
		claims.put("name", userPrincipal.getName());
		claims.put("lastName", userPrincipal.getLastName());
		claims.put("role", userPrincipal.getRole());
		claims.put("id", userPrincipal.getId());

		claims.put("permission", userPrincipal.getAuthorities().stream().map(item -> item.getAuthority()).toList());
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setClaims(claims)
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(secret_key)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token).getBody();
		String username = claims.get("username", String.class);
		if (username == null) {
			username = claims.getSubject();
		}
		return username;
	}
	public String getUserRoleFromJwtToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token).getBody();
		String role = claims.get("role", String.class);
		if (role == null) {
			role = claims.getSubject();
		}
		return role;
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		}
		return false;
	}
}
