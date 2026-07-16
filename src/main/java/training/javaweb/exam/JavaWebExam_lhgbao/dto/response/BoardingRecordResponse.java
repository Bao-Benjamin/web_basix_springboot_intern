package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import java.time.LocalDate;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecordResponse {
	private Integer id;
	private String petName;
	private String ownerName;
	private LocalDate checkin;
	private LocalDate expectedDate;
	private LocalDate actualDate;
	private Double lateFee;
	private Double totalFee;
	private BoardingStatus status;
	public BoardingRecordResponse() {
		super();
	}
	public BoardingRecordResponse(Integer id, String petName, String ownerName, LocalDate checkin,
			LocalDate expectedDate, LocalDate autualDate, Double lateFee, Double totalFee, BoardingStatus status) {
		super();
		this.id = id;
		this.petName = petName;
		this.ownerName = ownerName;
		this.checkin = checkin;
		this.expectedDate = expectedDate;
		this.actualDate = autualDate;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
		this.status = status;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getAutualDate() {
		return actualDate;
	}
	public void setAutualDate(LocalDate autualDate) {
		this.actualDate = autualDate;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public BoardingStatus getStatus() {
		return status;
	}
	public void setStatus(BoardingStatus status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public LocalDate getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}
	public Double getLateFee() {
		return lateFee;
	}
	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}
	
	
}
