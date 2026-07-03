package com.bao.web_java_pt1.entity;

import java.util.List;

public class Category {
	private Integer id;
	private String name;
	private List<Plant> plants;
	
	
	public Category() {
		super();
	}
	public Category(Integer id, String name, List<Plant> plants) {
		super();
		this.id = id;
		this.name = name;
		this.plants = plants;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Plant> getPlants() {
		return plants;
	}
	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", plants=" + plants + "]";
	}
	
	
}

