package com.wipro.bookingservice.exp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ErrorMessage>handleUserNotFoundException(Booking_Not_Found ex){
		ErrorMessage error=new ErrorMessage(ex.getMessage(),"Booking_not_Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
