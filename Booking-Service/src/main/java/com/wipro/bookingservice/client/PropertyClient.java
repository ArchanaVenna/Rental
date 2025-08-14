package com.wipro.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.bookingservice.dto.PropertyDto;

@FeignClient(name="Property-Service",url="http://localhost:8081")
public interface PropertyClient {
	 @GetMapping("/api/property/{id}")
	    PropertyDto getPropertyById(@PathVariable("id") Long id);

}
