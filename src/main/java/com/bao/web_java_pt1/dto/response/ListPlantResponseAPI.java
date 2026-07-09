package com.bao.web_java_pt1.dto.response;

import java.util.List;

public class ListPlantResponseAPI {
	private String messageError;
	private int ErrorCode;
	private List<PlantDTO> plantDTO;
	private long totalItems;
	private int totalPages;
	private int page;
	
	public ListPlantResponseAPI() {
		super();
	}
	
	public ListPlantResponseAPI(String messageError, int errorCode, List<PlantDTO> plantDTO, int totalItems,
			int totalPages, int page) {
		super();
		this.messageError = messageError;
		ErrorCode = errorCode;
		this.plantDTO = plantDTO;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
		this.page = page;
	}

	public long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	public List<PlantDTO> getPlantDTO() {
		return plantDTO;
	}
	public void setPlantDTO(List<PlantDTO> plantDTO) {
		this.plantDTO = plantDTO;
	}
	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ListPlantResponse [messageError=" + messageError + ", plantDTO=" + plantDTO + ", ErrorCode=" + ErrorCode
				+ "]";
	}
	
	
}
