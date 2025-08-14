package com.wipro.bookingservice.service;

import java.time.LocalDate;

import com.wipro.bookingservice.dto.BookingResponse;
import com.wipro.bookingservice.entities.Booking;

public interface BookingService {

	Booking requestBooking(Booking booking);

	BookingResponse approveBooking(Long id);

	Booking cancelBooking(Long id);

	boolean checkAvailability(Long propertyId, LocalDate bookingDate);

	Booking getBookingById(Long id);

}
