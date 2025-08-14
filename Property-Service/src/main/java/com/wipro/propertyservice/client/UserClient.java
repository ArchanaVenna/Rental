package com.wipro.propertyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.propertyservice.dt.UserDto;



@FeignClient(name="User-Service",url="http://localhost:8085")
public interface UserClient {

	@GetMapping("/api/user/{id}")
    UserDto getUserById(@PathVariable("id") Long id);
}
