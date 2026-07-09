package com.bao.web_java_pt1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bao.web_java_pt1.service.CustomUserDetailsService;

@Configuration
public class SecurityBean {

	private final CustomUserDetailsService customUserDetailsService;

	public SecurityBean(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);


		provider.setPasswordEncoder(passwordEncoder());

		return provider;
	}
	@Bean
	AuthenticationManager authenticationManager(
	        AuthenticationConfiguration configuration)
	        throws Exception {

	    return configuration.getAuthenticationManager();
	}
}
