package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.OwnerRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.OwnerDetailResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.OwnerResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.service.OwnerService;

@RestController
@RequestMapping("/api")
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	@GetMapping("/admin/all")
	public ResponseEntity<APIReponse<List<OwnerResponse>>> getAllOwners(){
		APIReponse<List<OwnerResponse>> result = new APIReponse<>(200, "Get all owners");
		result.setData(ownerService.getAllOwners());
		return ResponseEntity.status(200).body(result);
	}
	@PostMapping("/admin/create")
	public ResponseEntity<APIReponse<Integer>> addOwner(@RequestBody @Valid OwnerRequest request ){
		return ResponseEntity.status(200).body(new APIReponse<>(201, "Added an owner into database",ownerService.addOwner(request)));
	}
	@PutMapping("/admin/update/{id}")
	public ResponseEntity<APIReponse<Integer>> updateOwner(@RequestBody @Valid OwnerRequest request, @PathVariable int id) throws Exception{
		return ResponseEntity.status(200).body(new APIReponse<>(200, "Updated", ownerService.updateOwner(request, id)));
	}
	@GetMapping("/admin/search/{keyword}")
	public ResponseEntity<APIReponse<List<OwnerResponse>>> searchByNameOrPhone(@PathVariable String keyword){
		return ResponseEntity.status(200).body(new APIReponse<>(200, "Searching by phone number or name", ownerService.searchByNameOrPhone(keyword)));
	}
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<APIReponse<Integer>> deleteOwner(@PathVariable int id) throws Exception{
		return ResponseEntity.status(200).body(new APIReponse(200, "deleted successfully", ownerService.deleteOwner(id)));
	}
	@GetMapping("/admin/detail/{id}")
	public ResponseEntity<APIReponse<OwnerDetailResponse>> getOwnerWithPets(@PathVariable int id){
		return ResponseEntity.status(200).body(new APIReponse(200,"get owner in detail and their pets",ownerService.getOwnerWithPets(id)));
	}
}
