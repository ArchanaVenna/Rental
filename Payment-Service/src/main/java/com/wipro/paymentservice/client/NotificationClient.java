package com.wipro.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.paymentservice.dto.NotificationRequest;

@FeignClient(name="Notification-Service",url="http://localhost:8089")
public interface NotificationClient {
	
	 @PostMapping("/api/notification/send")
	     void sendNotification(@RequestBody NotificationRequest request);

}
