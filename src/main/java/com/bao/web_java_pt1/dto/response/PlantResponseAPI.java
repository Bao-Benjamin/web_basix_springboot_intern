package com.bao.web_java_pt1.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.bao.web_java_pt1.entity.Category;

public class PlantResponseAPI {
	private String messageError;
	private PlantDTO plantDTO;
	private int ErrorCode;
	public PlantResponseAPI(String messageError, PlantDTO plantDTO, int errorCode) {
		super();
		this.messageError = messageError;
		this.plantDTO = plantDTO;
		ErrorCode = errorCode;
	}
	public PlantResponseAPI() {
		super();
	}
	
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	public PlantDTO getPlantDTO() {
		return plantDTO;
	}
	public void setPlantDTO(PlantDTO plantDTO) {
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
		return "PlantResponse [messageError=" + messageError + ", plantDTO=" + plantDTO + ", ErrorCode=" + ErrorCode
				+ "]";
	}
	
	
}
