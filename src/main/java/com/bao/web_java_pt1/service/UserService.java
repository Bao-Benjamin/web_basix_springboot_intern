package com.bao.web_java_pt1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bao.web_java_pt1.dto.request.UserRequest;
import com.bao.web_java_pt1.dto.response.UserDTO;
import com.bao.web_java_pt1.dto.response.UserResponseAPI;
import com.bao.web_java_pt1.entity.User;
import com.bao.web_java_pt1.enums.Roles;
import com.bao.web_java_pt1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public int createUser(UserRequest userRequest) {
		userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

		int result = userRepository.createUser(userRequest.getUsername(), userRequest.getPassword(), Roles.ROLE_USER);
		return result;	
	}
	public UserDTO findByUsername(UserRequest userRequest) {
		return toUserDTO(userRepository.findByUsername(userRequest.getUsername()));
	}

	private UserDTO toUserDTO(User user) {
		return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
	}
}
