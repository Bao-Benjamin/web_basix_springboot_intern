package com.bao.web_java_pt1.dto.response;

public class UserResponseAPI {
	private String messageError;
	private int ErrorCode;
	private UserDTO userDTO;
	public UserResponseAPI() {
		super();
	}
	public UserResponseAPI(String messageError, int errorCode, UserDTO userDTO) {
		super();
		this.messageError = messageError;
		ErrorCode = errorCode;
		this.userDTO = userDTO;
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
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	@Override
	public String toString() {
		return "UserResponseAPI [messageError=" + messageError + ", ErrorCode=" + ErrorCode + ", userDTO=" + userDTO
				+ "]";
	}
	
	
	
}
