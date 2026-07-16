package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.JavaWebExam_lhgbao.entities.AdminSetting;

@Mapper
public interface AdminSettingMapper {
	AdminSetting getAdminSetting();
}
