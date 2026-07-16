package training.javaweb.exam.JavaWebExam_lhgbao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.AccountCreateRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.OwnerRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Account;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.roles.Roles;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.AccountRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.OwnerRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	OwnerService ownerService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public int createAccount(AccountCreateRequest request) throws Exception {
		Owner owner = ownerRepository.getOwnerById(request.getOwnerId());
		if(owner == null) throw new Exception("Owner's ID created for the new account is invalid");
		if(owner.getHadAccount()== true) throw new Exception("This account have created already");
		OwnerRequest ownerRequest = new OwnerRequest();
		ownerRequest.setHadAccount(true);
		ownerService.updateOwner(ownerRequest, owner.getId());
		return accountRepository.createAccount(owner.getPhoneNumber(), passwordEncoder.encode(request.getPassword()), owner.getId(),Roles.ROLE_CUSTOMER);
	}
}
