package com.bao.web_java_pt1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
	ResponseEntity<String> handlingRuntimeException(RuntimeException exception){
		return  ResponseEntity.badRequest().body(exception.getMessage()); 
	}
}
