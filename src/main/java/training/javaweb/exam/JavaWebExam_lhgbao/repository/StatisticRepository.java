package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.PetResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.StatisticResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.StatisticMapper;
@Repository
public class StatisticRepository {
	@Autowired
	public StatisticMapper statisticMapper;
	
	public StatisticResponse getGeneralStatistics() {
		return statisticMapper.getGeneralStatistics();
	}
	public int getMostFrequentlyPet() {
		return statisticMapper.getMostFrequentlyPet();
	}
}
