package training.javaweb.exam.JavaWebExam_lhgbao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.PetResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.StatisticResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.PetRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.StatisticRepository;

@Service
public class StatisticService {
	@Autowired
	StatisticRepository statisticRepository;
	@Autowired
	PetRepository petRepository;
	@Autowired
	PetService petService;
 	public StatisticResponse getGeneralStatistics() {
		return statisticRepository.getGeneralStatistics();
	}
	public PetResponse getMostFrequentlyPet() {
		int petId = statisticRepository.getMostFrequentlyPet();
		return petService.toPetResponse(petRepository.getPetById(petId));
		 
	}
}
