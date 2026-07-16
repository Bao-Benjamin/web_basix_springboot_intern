package training.javaweb.exam.JavaWebExam_lhgbao.dto.request;

import jakarta.validation.constraints.NotEmpty;

public class CareNoteRequest {
	@NotEmpty(message="id boarding can be not empty")
	private int boadingId;
	private String note;
	public CareNoteRequest() {
		super();
	}
	public CareNoteRequest(@NotEmpty(message = "id boarding can be not empty") int boadingId, String note) {
		super();
		this.boadingId = boadingId;
		this.note = note;
	}
	public int getBoadingId() {
		return boadingId;
	}
	public void setBoadingId(int boadingId) {
		this.boadingId = boadingId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
