package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import java.time.LocalDate;

public class CareNoteResponse {
		private int id;
		private int boardingRecordId;
		private String note;
		private LocalDate createdAt;
		public CareNoteResponse() {
			super();
		}
		public CareNoteResponse(int id, int boardingRecordId, String note, LocalDate createdAt) {
			super();
			this.id = id;
			this.boardingRecordId = boardingRecordId;
			this.note = note;
			this.createdAt = createdAt;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public LocalDate getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDate createdAt) {
			this.createdAt = createdAt;
		}
		public int getBoardingRecordId() {
			return boardingRecordId;
		}
		public void setBoardingRecordId(int boardingRecordId) {
			this.boardingRecordId = boardingRecordId;
		}
		
		
}
