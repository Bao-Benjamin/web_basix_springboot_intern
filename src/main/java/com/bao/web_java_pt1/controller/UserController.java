package com.bao.web_java_pt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.web_java_pt1.dto.request.UserRequest;
import com.bao.web_java_pt1.dto.response.UserResponseAPI;
import com.bao.web_java_pt1.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired 
	UserService userService;
	@PostMapping("/register")
	public ResponseEntity<Integer> createUser(@RequestBody UserRequest request) {
		return ResponseEntity.status(200).body(userService.createUser(request));
	}

}
