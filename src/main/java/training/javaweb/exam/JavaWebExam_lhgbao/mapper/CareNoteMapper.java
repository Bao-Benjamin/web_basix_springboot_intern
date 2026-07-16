package training.javaweb.exam.JavaWebExam_lhgbao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.CareNoteResponse;
import training.javaweb.exam.JavaWebExam_lhgbao.dto.response.NoteByEachOwnerResponse;
@Mapper
public interface CareNoteMapper {
	int addNote(@Param("boardingId") int boardingId, @Param("note") String note);
	List<NoteByEachOwnerResponse> getNoteByOwnerId(@Param("ownerId") int ownerId);
	List<CareNoteResponse> getNoteByRecordId(@Param("recordId") int recordId);

}
