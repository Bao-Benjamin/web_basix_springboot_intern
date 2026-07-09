package com.bao.web_java_pt1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bao.web_java_pt1.entity.User;
import com.bao.web_java_pt1.enums.Roles;

@Mapper
public interface UserMapper {
	int createUser (@Param("username") String username, @Param("password") String password ,  @Param("role") Roles role);
	User findByUsername(@Param("username") String username);
}
