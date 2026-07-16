package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.PetRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.PetMapper;

@Repository
public class PetRepository {
	@Autowired
	PetMapper petMapper;
	public List<Pet> getAllPets() {
		return petMapper.getAllPets();
	}
	public List<Pet> getByOwnerId(int ownerId){
		return petMapper.getByOwnerId(ownerId);
	}
	public int addPet(PetRequest request) {
		return petMapper.addPet(request);
	}
	public int updatePet(int id,PetRequest pet) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("pet", pet);
		return petMapper.updatePet(params);
	}
	public Pet getPetById(int id) {
		return petMapper.getPetById(id);
	}
	public int deletePet(int id) {
		return petMapper.deletePet(id);
	}
	public List<Pet> filterByType(String type){
		return petMapper.filterByType(type);
	}
	public List<Pet> findPetByOwner(int id){
		return petMapper.findPetByOwner(id);
	}
}
