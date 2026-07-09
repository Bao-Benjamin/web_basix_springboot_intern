package com.bao.web_java_pt1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bao.web_java_pt1.entity.User;
import com.bao.web_java_pt1.enums.Roles;
import com.bao.web_java_pt1.mapper.UserMapper;

@Repository
public class UserRepository {
	@Autowired
   UserMapper userMapper ;
   
   public int createUser(String username, String password, Roles role) {
	   return userMapper.createUser(username, password,role);
   }
   public User findByUsername(String username) {
	   return userMapper.findByUsername(username);
   }
}
