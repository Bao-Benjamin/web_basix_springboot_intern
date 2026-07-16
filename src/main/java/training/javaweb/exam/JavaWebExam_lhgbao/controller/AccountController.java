package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.AccountCreateRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.service.AccountService;

@RestController
@RequestMapping("/")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PostMapping("/create-account")
	public ResponseEntity<APIReponse<Integer>> createAccount(@RequestBody @Valid AccountCreateRequest request ) throws Exception{
		return ResponseEntity.status(201).body(new APIReponse<>(201, "created new account successfully",accountService.createAccount(request)));
	}
}
