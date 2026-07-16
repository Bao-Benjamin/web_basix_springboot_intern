package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.entities.AdminSetting;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.AdminSettingMapper;

@Repository
public class AdminSettingRepository {
	@Autowired
	AdminSettingMapper adminSettingMapper;
	public AdminSetting getAdminSetting() {
		return adminSettingMapper.getAdminSetting();
	}
}
