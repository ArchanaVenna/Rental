package com.wipro.bookingservice.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bookingservice.ens.BookingStatus;
import com.wipro.bookingservice.entities.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	boolean existsByPropertyIdAndBookingDateAndStatus(Long propertyId, LocalDate bookingDate, BookingStatus approved);

}
