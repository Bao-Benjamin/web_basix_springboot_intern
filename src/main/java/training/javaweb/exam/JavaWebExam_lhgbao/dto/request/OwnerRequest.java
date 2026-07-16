package training.javaweb.exam.JavaWebExam_lhgbao.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

/**
 * 
 */
/**
 * 
 */
public class OwnerRequest {
	@NotEmpty(message= "owner name can not empty")
	private String name;
	@NotEmpty(message="phone can not empty")
	private String phoneNumber;
	private String email;
	private String address;
	private Boolean hadAccount;
	public OwnerRequest() {
		super();
	}
	public OwnerRequest(@NotEmpty(message = "owner name can not empty") String name,
			@NotEmpty(message = "phone can not empty") String phoneNumber, String email, String address,
			Boolean hadAccount) {
		super();
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
