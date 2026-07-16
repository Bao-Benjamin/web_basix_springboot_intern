package training.javaweb.exam.JavaWebExam_lhgbao.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AccountCreateRequest {
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    private Integer ownerId;
	public AccountCreateRequest() {
		super();
	}
	public AccountCreateRequest(
			@NotBlank(message = "Password cannot be empty") @Size(min = 6, message = "Password must be at least 6 characters") String password,
			Integer ownerId) {
		super();
		this.password = password;
		this.ownerId = ownerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	} 

    
}
