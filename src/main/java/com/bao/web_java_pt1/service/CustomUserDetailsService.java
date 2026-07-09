package com.bao.web_java_pt1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bao.web_java_pt1.entity.User;
import com.bao.web_java_pt1.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
    UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = repository.findByUsername(username);

	      if(user == null){
	            throw new UsernameNotFoundException(username);
	      }
	      System.out.println("UserDetail"+ username );
	      return org.springframework.security.core.userdetails.User
	                .builder()
	                .username(user.getUsername())
	                .password(user.getPassword())
	                .roles(user.getRole().name().replace("ROLE_", ""))
	                .build();
	}
	
}
