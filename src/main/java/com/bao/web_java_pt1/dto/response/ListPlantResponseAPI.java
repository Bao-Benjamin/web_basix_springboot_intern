package com.bao.web_java_pt1.dto.response;

import java.util.List;

public class ListPlantResponseAPI {
	private String messageError;
	private List<PlantDTO> plantDTO;
	private int ErrorCode;
	
	public ListPlantResponseAPI() {
		super();
	}
	public ListPlantResponseAPI(String messageError, List<PlantDTO> plantDTO, int errorCode) {
		super();
		this.messageError = messageError;
		this.plantDTO = plantDTO;
		ErrorCode = errorCode;
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
