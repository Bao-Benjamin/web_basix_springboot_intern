package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;

public class OwnerResponse{
	private Integer id;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private Boolean hadAccount;
	public OwnerResponse() {
		super();
	}
	public OwnerResponse(Integer id, String name, String phoneNumber, String email, String address, Boolean hadAccount) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.hadAccount = hadAccount;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getHadAccount() {
		return hadAccount;
	}
	public void setHadAccount(Boolean hadAccount) {
		this.hadAccount = hadAccount;
	}
	

}
