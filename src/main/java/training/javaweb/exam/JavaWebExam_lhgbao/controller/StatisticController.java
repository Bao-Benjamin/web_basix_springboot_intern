package training.javaweb.exam.JavaWebExam_lhgbao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.APIReponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.PetRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.PetResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.StatisticResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;
import training.javaweb.exam.JavaWebExam_lhgbao.service.StatisticService;

@RestController
public class StatisticController {
	@Autowired
	StatisticService statisticService;
	@GetMapping("/admin/statistic")
	public ResponseEntity<APIReponse<StatisticResponse>> getGeneralStatistics() throws Exception {
		return ResponseEntity.status(200).body(new APIReponse<>(200, "get general statistic", statisticService.getGeneralStatistics())); 
	}
	@GetMapping("/admin/most-frequently")
	public ResponseEntity<APIReponse<PetResponse>>getMostFrequentlyPet() throws Exception {
		return ResponseEntity.status(200).body(new APIReponse<>(200, "get the most frequently boarded pet", statisticService.getMostFrequentlyPet())); 
	}
}
