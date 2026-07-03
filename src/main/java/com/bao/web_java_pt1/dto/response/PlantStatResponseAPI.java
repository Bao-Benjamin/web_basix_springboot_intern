package com.bao.web_java_pt1.dto.response;

import java.util.List;

public class PlantStatResponseAPI {
	private String messageError;
	private PlantStatsDTO plantStatsDTO;
	private int ErrorCode;
	
	
	public PlantStatResponseAPI() {
		super();
	}
	public PlantStatResponseAPI(String messageError, PlantStatsDTO plantStatsDTO, int errorCode) {
		super();
		this.messageError = messageError;
		this.plantStatsDTO = plantStatsDTO;
		ErrorCode = errorCode;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	public PlantStatsDTO getPlantStatsDTO() {
		return plantStatsDTO;
	}
	public void setPlantStatsDTO(PlantStatsDTO plantStatsDTO) {
		this.plantStatsDTO = plantStatsDTO;
	}
	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	@Override
	public String toString() {
		return "PlantStatResponseAPI [messageError=" + messageError + ", plantStatsDTO=" + plantStatsDTO
				+ ", ErrorCode=" + ErrorCode + "]";
	}
	
	
}
