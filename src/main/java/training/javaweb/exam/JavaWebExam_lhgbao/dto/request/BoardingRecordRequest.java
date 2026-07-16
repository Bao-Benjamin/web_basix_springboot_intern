package training.javaweb.exam.JavaWebExam_lhgbao.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecordRequest {
    private Integer petId;
    @NotEmpty(message="check-in date can not empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;
    @NotEmpty(message="expected checkout can not empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expectedCheckout;
	private String notes;
    
	public BoardingRecordRequest() {
		super();
	}
	
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getExpectedCheckout() {
		return expectedCheckout;
	}

	public void setExpectedCheckout(LocalDate expectedCheckout) {
		this.expectedCheckout = expectedCheckout;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
    
    
}
