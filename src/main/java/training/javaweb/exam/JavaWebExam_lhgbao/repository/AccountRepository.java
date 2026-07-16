package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.AccountMapper;

@Repository
public class AccountRepository {
	@Autowired
	AccountMapper accountMapper;
	public int createAccount(String userName,String password, int ownerId, Roles role) {
		return accountMapper.createAccount(userName,password, ownerId, role);
	}
}
