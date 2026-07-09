package com.bao.web_java_pt1.dto.response;

import com.bao.web_java_pt1.enums.Roles;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private Roles role;
	public UserDTO() {
		super();
	}
	public UserDTO(int id, String username, String password, Roles role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
