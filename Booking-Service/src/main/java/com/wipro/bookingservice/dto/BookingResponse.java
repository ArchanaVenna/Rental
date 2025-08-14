package com.wipro.bookingservice.dto;

import java.time.LocalDate;

import com.wipro.bookingservice.ens.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
	private Long id;
	private LocalDate bookingDate;
	private LocalDate approvalDate;
    private BookingStatus status;


    private UserDto user;
    private PropertyDto property;
    

   

}
