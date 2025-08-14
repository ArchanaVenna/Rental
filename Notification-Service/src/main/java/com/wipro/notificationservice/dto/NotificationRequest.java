package com.wipro.notificationservice.dto;

import com.wipro.notificationservice.ens.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {
    private Long userId;
    private Long paymentId; 
    private String message;
    private NotificationType type;

}
