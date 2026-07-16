package training.javaweb.exam.JavaWebExam_lhgbao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.PetRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;

@Mapper
public interface PetMapper {

    
    int addPet(PetRequest request);

    List<Pet> getAllPets();

    // B3. Xem chi tiết (kèm thông tin chủ nuôi)
    Pet findByIdWithOwner(@Param("id") Integer id);

    int updatePet(Map<String, Object> param);
    
    Pet getPetById(@Param("id")int id);

    int deletePet(@Param("id") Integer id);

    List<Pet> filterByType(@Param("type") String type);

    List<Pet> getByOwnerId(@Param("ownerId") Integer ownerId);

    List<Pet> findPetByOwner(@Param("owner_Id") Integer ownerId);
    
}