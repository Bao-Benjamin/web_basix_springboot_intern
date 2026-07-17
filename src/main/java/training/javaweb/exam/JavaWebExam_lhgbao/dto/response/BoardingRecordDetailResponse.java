package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import java.time.LocalDate;
import java.util.List;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;

public class BoardingRecordDetailResponse {
	private Integer id;
	private String petName;
	private String ownerName;
	private LocalDate checkin;
	private LocalDate expectedDate;
	private LocalDate actualDate;
	private Double lateFee;
	private Double totalFee;
	private BoardingStatus status;
	private List<CareNoteResponse> notes;
	public BoardingRecordDetailResponse() {
		super();
	}
	public BoardingRecordDetailResponse(Integer id, String petName, String ownerName, LocalDate checkin,
			LocalDate expectedDate, LocalDate actualDate, Double lateFee, Double totalFee, BoardingStatus status,
			List<CareNoteResponse> notes) {
		super();
		this.id = id;
		this.petName = petName;
		this.ownerName = ownerName;
		this.checkin = checkin;
		this.expectedDate = expectedDate;
		this.actualDate = actualDate;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
		this.status = status;
		this.notes = notes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalDate getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}
	public LocalDate getActualDate() {
		return actualDate;
	}
	public void setActualDate(LocalDate actualDate) {
		this.actualDate = actualDate;
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
	public List<CareNoteResponse> getNote() {
		return notes;
	}
	public void setNote(List<CareNoteResponse> notes) {
		this.notes = notes;
	}
	
	
}
