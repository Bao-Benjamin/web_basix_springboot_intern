package training.javaweb.exam.JavaWebExam_lhgbao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.javaweb.exam.JavaWebExam_lhgbao.entities.AdminSetting;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.AdminSettingRepository;

@Service
public class AdminSettingService {
	@Autowired
	AdminSettingRepository adminSettingRepository;
	public AdminSetting getAdminSetting() {
		return adminSettingRepository.getAdminSetting();
	}
}
