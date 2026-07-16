package training.javaweb.exam.JavaWebExam_lhgbao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.OwnerRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.OwnerDetailResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.OwnerResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.OwnerRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.PetRepository;

@Service
public class OwnerService {
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	PetRepository petRepository;
	
	public List<OwnerResponse> getAllOwners(){
		List<OwnerResponse> ownerResponseList = new ArrayList<>();
		for (Owner owner : ownerRepository.getAllOwners()) {
			ownerResponseList.add(toOwneResponse(owner));
		}
		 return ownerResponseList;
	}
	public int addOwner(OwnerRequest request) {
		return ownerRepository.addOwner(request.getName(), request.getPhoneNumber(), request.getEmail(),request.getAddress());
	}
	public int updateOwner(OwnerRequest request, int id) throws Exception {
		Owner owner = ownerRepository.getOwnerById(id);
		if(owner == null) throw new Exception("ID owner is invalid for updating");
		return ownerRepository.updateOwner(request.getName(),request.getPhoneNumber(),request.getEmail(), request.getAddress(), request.getHadAccount(),id);
	}
	public List<OwnerResponse> searchByNameOrPhone(String keyword){
		List<OwnerResponse> list = new ArrayList<>();
		for (Owner owner : ownerRepository.searchByNameOrPhone(keyword)) {
			list.add(toOwneResponse(owner));
		}
		return list;
	}
	public int deleteOwner(int id) throws Exception {
		Owner owner = ownerRepository.getOwnerById(id);
		if(owner == null) throw new Exception("ID owner is invalid for updating, can not delete this owner");
		return ownerRepository.deleteOwner(id);
	}
	public OwnerDetailResponse getOwnerWithPets(int ownerId) {
		OwnerDetailResponse ownerDetailResponse = new OwnerDetailResponse();
		ownerDetailResponse.setOwnerResponse(toOwneResponse(ownerRepository.getOwnerById(ownerId)));
		ownerDetailResponse.setListPets(petRepository.getByOwnerId(ownerId));
		return ownerDetailResponse;
	}
	private OwnerResponse toOwneResponse(Owner owner) {
	
		OwnerResponse ownerResponse = new OwnerResponse();
		ownerResponse.setId(owner.getId());
		ownerResponse.setName(owner.getName());
		ownerResponse.setPhoneNumber(owner.getPhoneNumber());
		ownerResponse.setEmail(owner.getEmail());
		ownerResponse.setAddress(owner.getAddress());
		ownerResponse.setHadAccount(owner.getHadAccount());
		return ownerResponse;
		
	}
	private Owner toOwner(OwnerRequest request) {
		Owner owner = new Owner();
		owner.setName(request.getName());
		owner.setEmail(request.getEmail());
		owner.setPhoneNumber(request.getPhoneNumber());
		owner.setAddress(request.getAddress());
		return owner;
	}
}
