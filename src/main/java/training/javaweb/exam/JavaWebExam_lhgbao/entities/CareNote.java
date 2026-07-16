package training.javaweb.exam.JavaWebExam_lhgbao.entities;

import java.time.LocalDateTime;

public class CareNote {
	  private Integer id;
	  private Integer boardingRecordId;
	  private String note;
	  private LocalDateTime createdAt;
	  public CareNote() {
		super();
	  }
	  public CareNote(Integer id, Integer boardingRecordId, String note, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.boardingRecordId = boardingRecordId;
		this.note = note;
		this.createdAt = createdAt;
	  }
	  public Integer getId() {
		  return id;
	  }
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  public Integer getBoardingRecordId() {
		  return boardingRecordId;
	  }
	  public void setBoardingRecordId(Integer boardingRecordId) {
		  this.boardingRecordId = boardingRecordId;
	  }
	  public String getNote() {
		  return note;
	  }
	  public void setNote(String note) {
		  this.note = note;
	  }
	  public LocalDateTime getCreatedAt() {
		  return createdAt;
	  }
	  public void setCreatedAt(LocalDateTime createdAt) {
		  this.createdAt = createdAt;
	  }
	  @Override
	  public String toString() {
		return "CareNote [id=" + id + ", boardingRecordId=" + boardingRecordId + ", note=" + note + ", createdAt="
				+ createdAt + "]";
	  }
	  
	  
}
