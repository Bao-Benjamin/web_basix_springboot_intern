package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.PetResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.StatisticResponse;

@Mapper
public interface StatisticMapper {
	StatisticResponse getGeneralStatistics();
	int getMostFrequentlyPet(); 
}
