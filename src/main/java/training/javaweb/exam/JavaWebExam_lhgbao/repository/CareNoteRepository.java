package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.CareNoteResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.NoteByEachOwnerResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.CareNoteMapper;

@Repository
public class CareNoteRepository {
	@Autowired
	CareNoteMapper careNoteMapper;
	public int addNote(int boardingId, String note) {
		return careNoteMapper.addNote(boardingId, note);
	}
	public List<NoteByEachOwnerResponse> getNoteByOwnerId(int ownerId){
		return careNoteMapper.getNoteByOwnerId(ownerId);
	}
	public List<CareNoteResponse> getNoteByRecordId(int recordId){
		return careNoteMapper.getNoteByRecordId(recordId);
	}
}
