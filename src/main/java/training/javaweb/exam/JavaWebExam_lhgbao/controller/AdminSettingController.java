package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.AdminSetting;
import training.javaweb.exam.JavaWebExam_lhgbao.service.AdminSettingService;

@RestController
@RequestMapping("/")
public class AdminSettingController {
	@Autowired
	AdminSettingService adminSettingService;
	@GetMapping("admin/price-setting")
	public ResponseEntity<APIReponse<AdminSetting>> getAdminSetting() {
		return ResponseEntity.status(200).body(new APIReponse<>(200, "Get admin setting", adminSettingService.getAdminSetting()));
	}
}
