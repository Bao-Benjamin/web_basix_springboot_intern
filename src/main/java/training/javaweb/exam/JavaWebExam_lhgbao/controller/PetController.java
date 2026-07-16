package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.PetRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.PetResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.service.PetService;

@RestController
@RequestMapping("/")
public class PetController {
	@Autowired
	PetService petService;
	
	@PostMapping("admin/create-pet")
	public ResponseEntity<APIReponse<Integer>> addPet(@RequestBody PetRequest request) throws Exception {
		return ResponseEntity.status(201).body(new APIReponse<>(201, "add new pet successfully", petService.addPet(request))); 
	}
	@GetMapping("/admin/get-all")
	public ResponseEntity<APIReponse<List<PetResponse>>> getAllPets(){
		return ResponseEntity.status(200).body(new APIReponse<>(200, "get all pets",petService.getAllPets()));
	}
	@PutMapping("/admin/update-pet/{id}")
	public ResponseEntity<APIReponse<Integer>> updatePet(@PathVariable int id,  @RequestBody  PetRequest request) throws Exception {
		System.out.println("request "+ request);
		return ResponseEntity.status(200).body(new APIReponse<>(200, "updated successfully", petService.updatePet(id,request))); 
	}
	@DeleteMapping("/admin/delete-pet/{id}")
	public ResponseEntity<APIReponse<Integer>> deletePet(@PathVariable int id) throws Exception {
		return ResponseEntity.status(200).body(new APIReponse<>(200, "updated successfully", petService.deletePet(id))); 
	}
	@GetMapping("/admin/filter-by-type/{type}")
	public ResponseEntity<APIReponse<List<PetResponse>>> filterByType(@PathVariable String type){
		return ResponseEntity.status(200).body(new APIReponse<>(200, "get all pets",petService.filterByType(type)));
	}
	@GetMapping("/admin/find-by-owner/{id}")
	public ResponseEntity<APIReponse<List<PetResponse>>> filterByType(@PathVariable int id){
		return ResponseEntity.status(200).body(new APIReponse<>(200, "get all pets",petService.findPetByOwner(id)));
	}
}
