package com.wipro.notificationservice.service;

import com.wipro.notificationservice.dto.NotificationRequest;
import com.wipro.notificationservice.entities.Notification;

public interface NotificationService {

	Notification sendNotification(NotificationRequest request);



}
