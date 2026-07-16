package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.CareNoteRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.CareNoteResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.NoteByEachOwnerResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.service.CareNoteService;

@RestController
@RequestMapping("/")
public class CareNoteController {
	@Autowired
	CareNoteService careNoteService;
	@PostMapping("/admin/add-note/")
	public ResponseEntity<APIReponse<Integer>> addNote(@RequestBody CareNoteRequest request){
		return ResponseEntity.status(201).body(new APIReponse<>(201, "add new note successfully", careNoteService.addNote(request) ));
	}
	@GetMapping("/admin/get-note-by-id/{ownerId}")
	public ResponseEntity<APIReponse<List<NoteByEachOwnerResponse>>> getNoteByOwnerId(@PathVariable int ownerId){
		return ResponseEntity.status(200).body(new APIReponse<>(200, "add new note successfully", careNoteService.getNoteByOwnerId(ownerId) ));
	}
	@GetMapping("/admin/get-note-by-record/{recordId}")
	public ResponseEntity<APIReponse<List<CareNoteResponse>>> getNoteByRecordId(@PathVariable int recordId){
		return ResponseEntity.status(200).body(new APIReponse<>(200, "add new note successfully", careNoteService.getNoteByRecordId(recordId) ));
	}
}
