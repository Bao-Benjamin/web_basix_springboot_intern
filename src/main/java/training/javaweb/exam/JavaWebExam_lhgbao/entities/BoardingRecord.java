package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecord {
	private Integer id;
    private Integer petId;
    private LocalDate checkInDate;
    private LocalDate expectedCheckout;
    private LocalDate actualCheckout;
    private Double baseFee;
    private Double lateFee;
    private Double totalFee;
	private BoardingStatus status;
	private String notes;
	
	
	public BoardingRecord() {
		super();
	}

	public BoardingRecord(Integer id, Integer petId, LocalDate checkInDate, LocalDate expectedCheckout,
			LocalDate actualCheckout, Double baseFee, Double lateFee, Double totalFee, BoardingStatus status) {
		super();
		this.id = id;
		this.petId = petId;
		this.checkInDate = checkInDate;
		this.expectedCheckout = expectedCheckout;
		this.actualCheckout = actualCheckout;
		this.baseFee = baseFee;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Double getBaseFee() {
		return baseFee;
	}
	public void setBaseFee(Double baseFee) {
		this.baseFee = baseFee;
	}
	public Double getLateFee() {
		return lateFee;
	}
	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public BoardingStatus getStatus() {
		return status;
	}
	public void setStatus(BoardingStatus status) {
		this.status = status;
	}
	public LocalDate getActualCheckout() {
		return actualCheckout;
	}
	public void setActualCheckout(LocalDate actualCheckout) {
		this.actualCheckout = actualCheckout;
	}
	
	public LocalDate getExpectedCheckout() {
		return expectedCheckout;
	}

	public void setExpectedCheckout(LocalDate expectedCheckout) {
		this.expectedCheckout = expectedCheckout;
	}

	@Override
	public String toString() {
		return "BoardingRecord [id=" + id + ", petId=" + petId + ", checkInDate=" + checkInDate + ", expectedCheckout="
				+ expectedCheckout + ", actualCheckout=" + actualCheckout + ", baseFee=" + baseFee + ", lateFee="
				+ lateFee + ", totalFee=" + totalFee + ", status=" + status + "]";
	}

	
    
}
