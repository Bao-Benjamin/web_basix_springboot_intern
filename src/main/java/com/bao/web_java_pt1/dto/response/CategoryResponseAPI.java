package com.bao.web_java_pt1.dto.response;

public class CategoryResponseAPI {
	private String messageError;
	private int ErrorCode;
	private CategoryDTO categoryDTO;
	
	
	public CategoryResponseAPI() {
		super();
	}
	public CategoryResponseAPI(String messageError, int errorCode, CategoryDTO categoryDTO) {
		super();
		this.messageError = messageError;
		ErrorCode = errorCode;
		this.categoryDTO = categoryDTO;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	} 
	
	
}
