package com.bao.web_java_pt1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
	    .csrf(csrf -> csrf.disable())

	    .authorizeHttpRequests(auth -> auth
	        .requestMatchers("/api/register","/api/plants/**").permitAll()
	        .requestMatchers("/index.html","/index.js","/style.css", "/login.js","/login.html").permitAll()
	        .requestMatchers("/admin/**").hasRole("ADMIN")
	        .requestMatchers("/user/**").hasRole("USER")
	        .anyRequest().authenticated()
	    )

	    .formLogin(form -> form
	        .successHandler((request, response, authentication) -> {

	            if (authentication.getAuthorities().stream()
	                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {

	                response.sendRedirect("/admin.html");
	                return;
	            }
	            response.sendRedirect("/index.html");
	        })
	        .permitAll()
	    )

	    .logout(logout -> logout
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/login?logout")
	        .invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .deleteCookies("JSESSIONID")
	        .permitAll()
	    );

	return http.build();
	}
}
