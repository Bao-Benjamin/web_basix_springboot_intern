//package training.javaweb.exam.JavaWebExam_lhgbao.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import training.javaweb.exam.JavaWebExam_lhgbao.apiFormat.ErrorResponse;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    // Bắt lỗi IllegalArgumentException (Lỗi dữ liệu không hợp lệ từ Service ném ra)
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
//        
//        ErrorResponse error = new ErrorResponse();
//        error.setErrorCode(HttpStatus.BAD_REQUEST.value()); // 400
//        error.setErrorMessage(ex.getMessage()); // Lấy câu message "Role của user..." ở tầng Service
//        
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//    }
//
//    // Bắt các lỗi hệ thống không lường trước được (NullPointer, SqlException...)
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
//        
//        ErrorResponse error = new ErrorResponse();
//        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value()); // 500
//        error.setErrorMessage(ex.getMessage());
//        
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
//    }
//}
