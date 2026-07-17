package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.request.BoardingRecordRequest;
import training.javaweb.exam.JavaWebExam_lhgbao.entities.BoardingRecord;

@Mapper
public interface BoardingRecordMapper {
	int createBoardingRecord(@Param("petId") Integer petId,@Param("checkInDate") LocalDate checkInDate, @Param("expectedReturnDate") LocalDate expectedReturnDate,
			@Param("baseFee") Double baseFee, @Param("totalFee") Double totalFee,@Param("notes") String notes
			);
	List<BoardingRecord> getAllBoardingRecord();
	
	int checkout(@Param("actualCheckoutDay") LocalDate actualCheckoutDay, @Param("lateFee") double lateFee, @Param("totalFee") double totalFee, @Param("recordId") int id);
	BoardingRecord getBoardingRecordById(@Param("id") int id);
	BoardingRecord getRecordDetailById(@Param("id") int id);
	List<BoardingRecord> getBoardingStatusRecords();
	List<BoardingRecord> getRecordByPetId(@Param("petId") int id);
	List<BoardingRecord> getRecordByOwnerId(@Param("ownerId") int id);
	List<BoardingRecord> getRecordByTime(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
