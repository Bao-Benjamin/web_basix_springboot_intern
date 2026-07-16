package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;

public class Owner {
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private LocalDateTime created;
	private Boolean hadAccount;
	public Owner() {
		super();
	}

	public Owner(Integer id, String name, String phoneNumber, String email, String address, LocalDateTime created,
			Boolean hadAccount) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phoneNumber;
		this.email = email;
		this.address = address;
		this.created = created;
		this.hadAccount = hadAccount;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phone;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phone = phoneNumber;
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
	
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", phoneNumber=" + phone + ", email=" + email + ", address="
				+ address + ", hadAccount=" + hadAccount + "]";
	}

}
