package com.wipro.notificationservice.entities;

import java.time.LocalDateTime;

import com.wipro.notificationservice.ens.NotificationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long paymentId; 
	private Long userId;
    private String message;
    
    private NotificationType type; // BOOKING, CANCELLATION, PAYMENT, etc.

    private LocalDateTime createdAt;

	

}
