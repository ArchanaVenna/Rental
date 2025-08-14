package com.wipro.notificationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.notificationservice.dto.NotificationRequest;
import com.wipro.notificationservice.entities.Notification;
import com.wipro.notificationservice.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationController {
	
	private final NotificationService notificationService;
	
	@PostMapping("/send")
	public ResponseEntity<Notification> sendNotification(@RequestBody NotificationRequest request) {
        Notification savedNotification = notificationService.sendNotification(request);
        return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
	
	
	}
	

}
