package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;

@Mapper
public interface AccountMapper {
	int createAccount(@Param("username") String username, @Param("password") String password,@Param("ownerId") int ownerId, @Param("roles") Roles role);
}
