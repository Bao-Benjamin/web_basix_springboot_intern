package com.bao.web_java_pt1.dto.response;

public class CategoryStatResponse {
	private String categoryName;
	private Long totalQuantity;
	
	public CategoryStatResponse() {
		super();
	}
	public CategoryStatResponse(String categoryName, Long totalQuantity) {
		super();
		this.categoryName = categoryName;
		this.totalQuantity = totalQuantity;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	
}
