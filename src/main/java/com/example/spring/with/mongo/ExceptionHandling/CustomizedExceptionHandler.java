package com.example.spring.with.mongo.ExceptionHandling;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchElementException.class)
 public ResponseEntity<Object>	NoSuchElementExceptionHandler(NoSuchElementException noSuchElementException){
		Map<String,String> error  =  new HashMap<>();
		error.put("Error Message", noSuchElementException.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
