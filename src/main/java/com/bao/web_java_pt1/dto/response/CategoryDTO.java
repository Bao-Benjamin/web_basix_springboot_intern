package com.bao.web_java_pt1.dto.response;

public class CategoryDTO {
	private String name;
	
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
