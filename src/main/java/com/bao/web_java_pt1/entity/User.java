package com.bao.web_java_pt1.entity;

import com.bao.web_java_pt1.enums.Roles;

public class User {
	private int id;
	private String name;
	private String password;
	private Roles role;
	public User() {
		super();
	}
	public User(int id, String username, String password, Roles role) {
		super();
		this.id = id;
		this.name = username;
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
		return name;
	}
	public void setUsername(String username) {
		this.name = username;
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
		return "User [id=" + id + ", username=" + name + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
