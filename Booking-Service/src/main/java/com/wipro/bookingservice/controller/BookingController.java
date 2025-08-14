package com.wipro.bookingservice.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bookingservice.dto.BookingResponse;
import com.wipro.bookingservice.entities.Booking;
import com.wipro.bookingservice.service.BookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/request")
    public Booking requestBooking(@RequestBody Booking booking) {
        return bookingService.requestBooking(booking);
    }
	
	  @PutMapping("/approve/{id}")
	    public BookingResponse approveBooking(@PathVariable Long id) {
	        return bookingService.approveBooking(id);
	    }
	  @GetMapping("/{id}")
	  public Booking getBookingById(@PathVariable Long id) {
	      return bookingService.getBookingById(id);
	  }

	    @PutMapping("/cancel/{id}")
	    public Booking cancelBooking(@PathVariable Long id) {
	        return bookingService.cancelBooking(id);
	    }

	    @GetMapping("/availability")
	    public boolean checkAvailability(@RequestParam Long propertyId, @RequestParam String date) {
	        LocalDate bookingDate = LocalDate.parse(date);
	        return bookingService.checkAvailability(propertyId, bookingDate);
	    }
	

}
