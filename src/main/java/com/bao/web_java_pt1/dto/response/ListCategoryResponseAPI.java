package com.bao.web_java_pt1.dto.response;

import java.util.List;

public class ListCategoryResponseAPI {
	private String messageError;
	private int ErrorCode;
	private List<CategoryDTO> categoryDTO;
	
	public ListCategoryResponseAPI(String messageError, int errorCode, List<CategoryDTO> categoryDTO) {
		super();
		this.messageError = messageError;
		ErrorCode = errorCode;
		this.categoryDTO = categoryDTO;
	}
	public ListCategoryResponseAPI() {
		super();
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
	public List<CategoryDTO> getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(List<CategoryDTO> categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	
	
	
}
