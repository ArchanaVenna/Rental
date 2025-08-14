package com.wipro.paymentservice.service;

import com.wipro.paymentservice.dto.PaymentRequest;
import com.wipro.paymentservice.dto.PaymentResponse;

public interface PaymentService {

	PaymentResponse processPayment(PaymentRequest request);

}
