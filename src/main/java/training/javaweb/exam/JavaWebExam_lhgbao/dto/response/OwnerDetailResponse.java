package training.javaweb.exam.JavaWebExam_lhgbao.dto.response;

import java.util.List;

import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;

public class OwnerDetailResponse {
	private OwnerResponse ownerResponse;
	private List<Pet> listPets;
	public OwnerDetailResponse() {
		super();
	}
	public OwnerDetailResponse(OwnerResponse ownerResponse, List<Pet> listPets) {
		super();
		this.ownerResponse = ownerResponse;
		this.listPets = listPets;
	}
	public OwnerResponse getOwnerResponse() {
		return ownerResponse;
	}
	public void setOwnerResponse(OwnerResponse ownerResponse) {
		this.ownerResponse = ownerResponse;
	}
	public List<Pet> getListPets() {
		return listPets;
	}
	public void setListPets(List<Pet> listPets) {
		this.listPets = listPets;
	}
	@Override
	public String toString() {
		return "OwnerDetailResponse [ownerResponse=" + ownerResponse + ", listPets=" + listPets + "]";
	}
	
	
	
	
}
