package com.wipro.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.notificationservice.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
