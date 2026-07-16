package training.javaweb.exam.JavaWebExam_lhgbao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.CareNoteRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.CareNoteResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.NoteByEachOwnerResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.CareNoteRepository;

@Service
public class CareNoteService {
	@Autowired
	CareNoteRepository careNoteRepository;
	public int addNote(CareNoteRequest request) {
		return careNoteRepository.addNote(request.getBoadingId(), request.getNote());
	}
	public List<NoteByEachOwnerResponse> getNoteByOwnerId(int ownerId){
		return careNoteRepository.getNoteByOwnerId(ownerId);
	}
	public List<CareNoteResponse> getNoteByRecordId(int recordId){
		return careNoteRepository.getNoteByRecordId(recordId);
	}
}
