package com.TransTech.LalResidency.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
	@Value("${jwt.secret}")
	private String secretKey;
	@Value("${jwt.expirationTime")
	private long expirationTime;
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter(secretKey, expirationTime);
	}

}
