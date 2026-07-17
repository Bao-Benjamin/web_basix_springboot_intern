package training.javaweb.exam.JavaWebExam_lhgbao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.PetRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.PetResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.OwnerRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.PetRepository;

@Service
public class PetService {
	@Autowired
	PetRepository petRepository;
	@Autowired
	OwnerRepository ownerRepository;
	public List<PetResponse> getAllPets(){
		List<PetResponse> response = new ArrayList<>();
		for (Pet pet : petRepository.getAllPets()) {
			response.add(toPetResponse(pet));
		}
		return response;
	}
	public int addPet(PetRequest request) throws Exception {
		Owner owner = ownerRepository.getOwnerById(request.getOwnerId());
		if(owner == null) throw new Exception("Owner' ID of this pet is invalid");
		return petRepository.addPet(request);
	}
	public int updatePet(int id, PetRequest request) throws Exception {
		System.out.println("requesr: "+request);
		Pet pet = petRepository.getPetById(id);
		if(pet == null) throw new Exception("this pet is not found");
		return petRepository.updatePet(pet.getId(),request);
	}
	public int deletePet(int id) {
		return petRepository.deletePet(id);
	}
	public List<PetResponse> filterByType(String type){
		List<PetResponse> list = new ArrayList<>();
		for (Pet pet : petRepository.filterByType(type)) {
			list.add(toPetResponse(pet));
		}
		return list;
	}
	public List<PetResponse> findPetByOwner(int id){
		List<PetResponse> list = new ArrayList<>();
		for (Pet pet : petRepository.findPetByOwner(id)) {
			list.add(toPetResponse(pet));
		}
		return list;
	}
	public PetResponse toPetResponse(Pet pet) {
		Owner owner = ownerRepository.getOwnerById(pet.getOwnerId());
		return new PetResponse(pet.getId(),pet.getName(),pet.getAge(),owner.getName(),pet.getType(),pet.getWeight(),pet.getBreed(), pet.getImage());
	}
}
