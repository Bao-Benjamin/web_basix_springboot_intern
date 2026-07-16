package training.javaweb.exam.JavaWebExam_lhgbao.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.BoardingRecordResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.CheckoutResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.AdminSetting;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.BoardingRecord;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Owner;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.Pet;
import training.javaweb.exam.JavaWebExam_lhgbao.enums.status.BoardingStatus;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.AdminSettingRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.BoardingRecordRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.OwnerRepository;
import training.javaweb.exam.JavaWebExam_lhgbao.repository.PetRepository;

@Service
public class BoardingRecordService {
	@Autowired
	BoardingRecordRepository boardingRecordRepository;
	@Autowired
	AdminSettingRepository adminSettingRepository ;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	PetRepository petRepository;
	
	@Transactional
	public int createBoardingRecord(BoardingRecordRequest request) throws Exception {
		AdminSetting adminSetting = adminSettingRepository.getAdminSetting();
		if(adminSetting == null) throw new Exception("admin setting is invalid for getting service prices in BoardingRecordService");
		double baseFee = adminSetting.countBaseFee(request.getCheckInDate(), request.getExpectedCheckout());
		double totalFee = baseFee;
		return boardingRecordRepository.createBoardingRecord(request.getPetId(), request.getCheckInDate(), request.getExpectedCheckout(), baseFee, totalFee, request.getNotes());
	}

	public List<BoardingRecordResponse> getAllBoardingRecord() {
		List<BoardingRecordResponse> list = new ArrayList<>();
		for (BoardingRecord boardingRecord : boardingRecordRepository.getAllBoardingRecord()) {
			list.add(toBoardingRecordResponse(boardingRecord));
		}
		return list;
	}
	@Transactional
	public CheckoutResponse checkout(LocalDate actualCheckoutDay, int id) throws Exception {
		AdminSetting adminSetting = adminSettingRepository.getAdminSetting();
		if(adminSetting == null) throw new Exception("admin setting is invalid for getting service prices in BoardingRecordService");
		BoardingRecord boardingRecord = boardingRecordRepository.getBoardingRecordById(id);
		if(boardingRecord == null) throw new Exception("BoardingRecord is invalid for checkout in BoardingRecordService");
		if(boardingRecord.getStatus() == BoardingStatus.RETURNED) throw new Exception("this pet was checked out");
		double lateFee = adminSetting.countLateFee(boardingRecord.getExpectedCheckout(), actualCheckoutDay);
		double baseFee = (boardingRecord.getBaseFee() != null) ? boardingRecord.getBaseFee() : 0.0;
		double totalFee = lateFee + boardingRecord.getBaseFee();
		boardingRecordRepository.checkout(actualCheckoutDay,lateFee, totalFee, id);
		long numberOfDayOnBoard = ChronoUnit.DAYS.between(boardingRecord.getCheckInDate(), actualCheckoutDay);
		return new CheckoutResponse(numberOfDayOnBoard,baseFee, lateFee,totalFee);
	}
	public List<BoardingRecordResponse> getBoardingStatusRecords(){
		List<BoardingRecordResponse> list = new ArrayList<>();
		for (BoardingRecord boardingRecord : boardingRecordRepository.getBoardingStatusRecords()) {
			list.add(toBoardingRecordResponse(boardingRecord));
		}
		return list;
	}
	public List<BoardingRecordResponse> getRecordByPetId(int id){
		List<BoardingRecordResponse> list = new ArrayList<>();
		for (BoardingRecord boardingRecord : boardingRecordRepository.getRecordByPetId(id)) {
			list.add(toBoardingRecordResponse(boardingRecord));
		}
		return list;
	}
	public List<BoardingRecordResponse> getRecordByOwnerId(int id){
		List<BoardingRecordResponse> list = new ArrayList<>();
		for (BoardingRecord boardingRecord : boardingRecordRepository.getRecordByOwnerId(id)) {
			list.add(toBoardingRecordResponse(boardingRecord));
		}
		return list;
	}
	public List<BoardingRecordResponse> getRecordByTime(LocalDate start, LocalDate end ){
		List<BoardingRecordResponse> list = new ArrayList<>();
		for (BoardingRecord boardingRecord : boardingRecordRepository.getRecordByTime(start, end)) {
			list.add(toBoardingRecordResponse(boardingRecord));
		}
		return list;
	}
	private BoardingRecordResponse toBoardingRecordResponse(BoardingRecord boardingRecord) {
		Pet pet = petRepository.getPetById(boardingRecord.getPetId()); 
		Owner owner = ownerRepository.getOwnerById(pet.getOwnerId());
		return new BoardingRecordResponse(boardingRecord.getId(), pet.getName(),owner.getName(),boardingRecord.getCheckInDate(),boardingRecord.getExpectedCheckout(),boardingRecord.getActualCheckout(),boardingRecord.getLateFee(),boardingRecord.getTotalFee(), boardingRecord.getStatus());
	}
	
}
