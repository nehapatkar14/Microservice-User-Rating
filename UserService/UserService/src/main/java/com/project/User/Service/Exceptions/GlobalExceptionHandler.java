package com.project.User.Service.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.project.User.Service.Payload.*;
import com.project.User.Service.Exceptions.*;
import lombok.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<ApiResponse> handlerUSerNotFoundException(UserNotFoundException ex) {
	        String message = ex.getMessage();
	        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
}
}
