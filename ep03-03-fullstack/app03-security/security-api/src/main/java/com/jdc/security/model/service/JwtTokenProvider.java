package com.jdc.security.model.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JwtTokenProvider {
	
	public enum Type {
		Access, Refresh
	}
	
	private SecretKey secret = Jwts.SIG.HS256.key().build();

	@Value("${app.jwt.issuer}")
	private String issuer;
	@Value("${app.jwt.access-life}")
	private int accessLife;
	@Value("${app.jwt.refresh-life}")
	private int refreshLife;

	public String generateAccessToken(Authentication authentication) {
		return generate(authentication, Type.Access);
	}

	public String generateRefreshToken(Authentication authentication) {
		return generate(authentication, Type.Refresh);
	}

	public Authentication parseAccessToken(String token) {
		return parse(token, Type.Access);
	}

	public Authentication parseRefreshToken(String token) {
		return parse(token, Type.Refresh);
	}

	private String generate(Authentication authentication, Type type) {
		
		var issueAt = new Date();
		var calendar = Calendar.getInstance();
		calendar.setTime(issueAt);
		
		if(type == Type.Access) {
			calendar.add(Calendar.MINUTE, accessLife);
		} else if (type == Type.Refresh) {
			calendar.add(Calendar.MINUTE, refreshLife);
		}
		
		return Jwts.builder()
			.subject(authentication.getName())
			.claim("role", authentication.getAuthorities().stream()
					.map(a -> a.getAuthority()).collect(Collectors.joining(",")))
			.claim("type", type.name())
			.signWith(secret)
			.issuer(issuer)
			.issuedAt(issueAt)
			.expiration(calendar.getTime())
			.compact();
	}

	private Authentication parse(String token, Type type) {
		
		var payload = Jwts.parser()
				.verifyWith(secret)
				.requireIssuer(issuer)
				.require("type", type.name())
				.build()
				.parseSignedClaims(token).getPayload();
		
		var username = payload.getSubject();
		var roles = Arrays.stream(payload.get("role", String.class).split(","))
				.map(a -> new SimpleGrantedAuthority(a))
				.toList();
		
		return UsernamePasswordAuthenticationToken.authenticated(username, null, roles);
	}


}
