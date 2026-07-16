package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.types.Types;

public class NoteByEachOwnerResponse {
	private int id;
	private int boardingRecordId;
	private String note;
	private int petId;
	private String petName;
	private Types type;
	private int owner_id;
	private String ownerName;
	public NoteByEachOwnerResponse() {
		super();
	}
	public NoteByEachOwnerResponse(int id, int boardingRecordId, String note, int petId, String petName, Types type,
			int owner_id, String ownerName) {
		super();
		this.id = id;
		this.boardingRecordId = boardingRecordId;
		this.note = note;
		this.petId = petId;
		this.petName = petName;
		this.type = type;
		this.owner_id = owner_id;
		this.ownerName = ownerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardingRecordId() {
		return boardingRecordId;
	}
	public void setBoardingRecordId(int boardingRecordId) {
		this.boardingRecordId = boardingRecordId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
}
