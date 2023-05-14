package com.restaurante.dsi.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.restaurante.dsi.utils.UserDetailsImpl;

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
		return Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token).getBody()
				.getSubject();
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
