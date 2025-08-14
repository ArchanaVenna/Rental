package com.wipro.notificationservice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.wipro.notificationservice.dto.NotificationRequest;
import com.wipro.notificationservice.entities.Notification;
import com.wipro.notificationservice.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
     
	
	private  final NotificationRepository notificationRepository;

	@Override
	public Notification sendNotification(NotificationRequest request) {
		Notification notification = Notification.builder()
                .userId(request.getUserId())
                .paymentId(request.getPaymentId())
                .message(request.getMessage())
                .type(request.getType())
                .createdAt(LocalDateTime.now())
                .build();

        // Save notification (you can also send email here)
        return notificationRepository.save(notification);
	}

	

	 
	
	
	
	
	
}
