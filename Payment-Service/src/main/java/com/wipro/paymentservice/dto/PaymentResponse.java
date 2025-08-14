package com.wipro.paymentservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
	 private String transactionId;
	    private Long bookingId;
	    private Long userId;
	    private double amount;
	    private LocalDateTime paymentDate;
	    private String status;
	    private String message;
	
	
	
}
