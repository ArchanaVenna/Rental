package com.wipro.bookingservice.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bookingservice.client.PropertyClient;
import com.wipro.bookingservice.client.UserClient;
import com.wipro.bookingservice.dto.BookingResponse;
import com.wipro.bookingservice.dto.PropertyDto;
import com.wipro.bookingservice.dto.UserDto;
import com.wipro.bookingservice.ens.BookingStatus;
import com.wipro.bookingservice.entities.Booking;
import com.wipro.bookingservice.exp.Booking_Not_Found;
import com.wipro.bookingservice.repository.BookingRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	 private final UserClient userClient;
	 private final PropertyClient propertyClient;


	public Booking requestBooking(Booking booking) {
		userClient.getUserById(booking.getUserId());
        propertyClient.getPropertyById(booking.getPropertyId());

        // Check availability
        boolean alreadyBooked = bookingRepo
            .existsByPropertyIdAndBookingDateAndStatus(booking.getPropertyId(), booking.getBookingDate(), BookingStatus.APPROVED);
        if (alreadyBooked) {
            throw new RuntimeException("Property is already booked on this date.");
        }

        booking.setStatus(BookingStatus.REQUESTED);
		
		return bookingRepo.save(booking);
	}

	

	public BookingResponse approveBooking(Long id) {
		Booking booking = bookingRepo.findById(id)
	            .orElseThrow(() -> new Booking_Not_Found("Booking not found"));

	        booking.setStatus(BookingStatus.APPROVED);
	        booking.setApprovalDate(LocalDate.now());
	         bookingRepo.save(booking);
	        UserDto user = userClient.getUserById(booking.getUserId());
	        PropertyDto property = propertyClient.getPropertyById(booking.getPropertyId());

	        return new BookingResponse(
	                booking.getId(),
	                booking.getBookingDate(),
	                booking.getApprovalDate(),
	                booking.getStatus(),
	                user,
	                property
	        );
	    }



	@Override
	public Booking cancelBooking(Long id) {
		 Booking booking = bookingRepo.findById(id)
		            .orElseThrow(() -> new RuntimeException("Booking not found"));

		        booking.setStatus(BookingStatus.CANCELLED);
		        return bookingRepo.save(booking);
	}



	@Override
	public boolean checkAvailability(Long propertyId, LocalDate bookingDate) {
		return !bookingRepo
	            .existsByPropertyIdAndBookingDateAndStatus(propertyId, bookingDate, BookingStatus.APPROVED);
	}



	@Override
	public Booking getBookingById(Long id) {
		 return bookingRepo.findById(id)
		            .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
	}
	
}
