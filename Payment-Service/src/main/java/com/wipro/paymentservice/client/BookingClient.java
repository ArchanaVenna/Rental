package com.wipro.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.paymentservice.dto.BookingDto;

@FeignClient(name = "Booking-Service", url = "http://localhost:8087")
public interface BookingClient {
	@GetMapping("/api/booking/{id}")
    BookingDto getBookingById(@PathVariable Long id);
	

}
