package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;

@Mapper
public interface OwnerMapper {
	List<Owner> getAllOwners();
	int addOwner(@Param("name") String name, @Param("phone")String phone, @Param("email")String email, @Param("address")  String address);
	Owner getOwnerById(int id);
    int updateOwner(@Param("name") String name, @Param("phoneNumber")String phone, @Param("email")String email, @Param("address")  String address, 
    		@Param("had_account")boolean hadAccount, @Param("id_owner") int id);
    List<Owner> searchByNameOrPhone(@Param("keyword") String keyword);
    int deleteOwner(@Param("id_owner") int id);
//
//    // A2. Hiển thị danh sách tổng quan
//    List<Owner> findAll();
//
//    // A3. Xem chi tiết Owner (Entity Owner cần chứa thêm `private List<Pet> pets;` để map n-1)
//    Owner findByIdWithPets(@Param("id") Integer id);
//
//    // A4. Cập nhật thông tin chủ nuôi
//    int update(Owner owner);
//
//    // A5. Tìm kiếm theo tên hoặc SĐT
//    List<Owner> searchByNameOrPhone(@Param("keyword") String keyword);
//
//    // A7. Xóa chủ nuôi
//    int deleteById(@Param("id") Integer id);
//    
//    // Bổ sung phục vụ E1 (Thống kê: Tổng Owner)
//    long countTotalOwners();
}
