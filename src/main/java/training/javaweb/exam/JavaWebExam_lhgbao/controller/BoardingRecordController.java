package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.BoardingRecordDetailResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.BoardingRecordResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.CheckoutResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.service.BoardingRecordService;

@RestController("/boarding-record")
public class BoardingRecordController {
	@Autowired
	BoardingRecordService boardingRecordService;
	@PostMapping("/admin/create-record")
	public ResponseEntity<APIReponse<Integer>> createBoardingRecord(@RequestBody BoardingRecordRequest request) throws Exception{
		return ResponseEntity.status(201).body(new APIReponse(201, "Created new boarding record successfully", boardingRecordService.createBoardingRecord(request)));
	}
	@GetMapping("/admin/get-all-record")
	public ResponseEntity<APIReponse<List<BoardingRecordResponse>>> getAllBoardingRecord(){
		return ResponseEntity.status(200).body(new APIReponse(200, "Get all boarding records", boardingRecordService.getAllBoardingRecord()));
	}
	@PostMapping("/admin/check-out/{id}")
	public ResponseEntity<APIReponse<CheckoutResponse>> checkout(@PathVariable int id, @RequestParam LocalDate actualCheckout) throws Exception{
		return ResponseEntity.status(200).body(new APIReponse(200, "Checkout successfully", boardingRecordService.checkout(actualCheckout,id)));
	}
	@GetMapping("/admin/get-record-boarding_status")
	public ResponseEntity<APIReponse<List<BoardingRecordResponse>>> getBoardingStatusRecords(){
		return ResponseEntity.status(200).body(new APIReponse(200, "Get all records being in boarding status ", boardingRecordService.getBoardingStatusRecords()));
	}
	@GetMapping("/admin/get-record-by/{petId}")
	public ResponseEntity<APIReponse<List<BoardingRecordResponse>>> getRecordByPetId(@PathVariable int petId){
		return ResponseEntity.status(200).body(new APIReponse(200, "Get all records by Pet's Id ", boardingRecordService.getRecordByPetId(petId)));
	}
	@GetMapping("/admin/get-record-by-owner/{ownerId}")
	public ResponseEntity<APIReponse<List<BoardingRecordResponse>>> getRecordByOwnerId(@PathVariable int ownerId){
		return ResponseEntity.status(200).body(new APIReponse(200, "Get all records by Pet's Id ", boardingRecordService.getRecordByOwnerId(ownerId)));
	}
	@GetMapping("/admin/get-record-by-time/")
	public ResponseEntity<APIReponse<List<BoardingRecordResponse>>> getRecordByOwnerId(@RequestParam LocalDate start, @RequestParam LocalDate end){
		return ResponseEntity.status(200).body(new APIReponse(200, "Get all records by Pet's Id ", boardingRecordService.getRecordByTime(start, end)));
	}
	@GetMapping("admin/get-record-detail/{id}")
	public ResponseEntity<APIReponse<BoardingRecordDetailResponse>> getRecordDetailById(@PathVariable int id){
		return ResponseEntity.status(200).body(new APIReponse(200, "Get all records by Pet's Id ", boardingRecordService.getRecordDetailById(id)));
	}
}
