package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.OwnerMapper;

@Repository
public class OwnerRepository {
	@Autowired
	OwnerMapper ownerMapper;
	public List<Owner> getAllOwners(){
		return ownerMapper.getAllOwners();	
	}
	public int addOwner(String name, String phone, String email,String address) {
		return ownerMapper.addOwner(name, phone, email,address);
	}
	public Owner getOwnerById(int id) {
		return ownerMapper.getOwnerById(id);
	}
	public int updateOwner(String name, String phone, String email,  String address, boolean hadAccount, int id) {
		return ownerMapper.updateOwner(name, phone, email, address, hadAccount ,id);
	}
	public List<Owner> searchByNameOrPhone(String keyword){
		return ownerMapper.searchByNameOrPhone(keyword);
	}
	public int deleteOwner(int id) {
		return ownerMapper.deleteOwner(id);
	}
}
