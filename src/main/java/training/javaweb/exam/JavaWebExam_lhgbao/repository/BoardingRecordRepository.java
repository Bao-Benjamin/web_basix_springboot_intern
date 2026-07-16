package training.javaweb.exam.JavaWebExam_lhgbao.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.BoardingRecord;
import training.javaweb.exam.JavaWebExam_lhgbao.mapper.BoardingRecordMapper;

@Repository
public class BoardingRecordRepository {
	@Autowired
	BoardingRecordMapper boardingRecordMapper;
	public int createBoardingRecord( int petId,LocalDate checkInDate,  LocalDate expectedReturnDate, double baseFee,double totalFee, String notes) {
		return boardingRecordMapper.createBoardingRecord(petId,checkInDate,  expectedReturnDate,
				 baseFee,totalFee, notes);
	}
	public List<BoardingRecord> getAllBoardingRecord() {
		return boardingRecordMapper.getAllBoardingRecord();
	}
	public int checkout(LocalDate actualCheckoutDay, double lateFee, double totalFee, int id) {
		return boardingRecordMapper.checkout(actualCheckoutDay,lateFee, totalFee, id);
	}
	public BoardingRecord getBoardingRecordById(int id) {
		return boardingRecordMapper.getBoardingRecordById(id);
	}
	public List<BoardingRecord> getBoardingStatusRecords(){
		return boardingRecordMapper.getBoardingStatusRecords();
	}
	public List<BoardingRecord> getRecordByPetId(int id){
		return boardingRecordMapper.getRecordByPetId(id);
	}
	public List<BoardingRecord> getRecordByOwnerId(int id){
		return boardingRecordMapper.getRecordByOwnerId(id);
	}
	public List<BoardingRecord> getRecordByTime(LocalDate start, LocalDate end){
		return boardingRecordMapper.getRecordByTime(start, end);
	}
}
