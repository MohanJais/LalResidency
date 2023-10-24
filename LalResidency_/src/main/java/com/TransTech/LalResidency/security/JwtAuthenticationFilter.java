package com.TransTech.LalResidency.security;

import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final String secretKey;
	private final long expirationTime;
	
	

}
