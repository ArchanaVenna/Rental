package com.wipro.paymentservice.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.paymentservice.client.BookingClient;
import com.wipro.paymentservice.dto.BookingDto;
import com.wipro.paymentservice.dto.PaymentRequest;
import com.wipro.paymentservice.dto.PaymentResponse;
import com.wipro.paymentservice.ens.PaymentStatus;
import com.wipro.paymentservice.entities.Payment;
import com.wipro.paymentservice.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
    private final BookingClient bookingClient;

    @Override
	public PaymentResponse processPayment(PaymentRequest request) {
    	 BookingDto booking = bookingClient.getBookingById(request.getBookingId());

         if (booking == null || !"APPROVED".equalsIgnoreCase(booking.getStatus())) {
             return PaymentResponse.builder()
                     .transactionId(null)
                     .bookingId(request.getBookingId())
                     .userId(null)
                     .amount(request.getAmount())
                     .paymentDate(LocalDateTime.now())
                     .status("FAILED")
                     .message("Booking not approved or not found.")
                     .build();
         }

         Payment payment = paymentRepository.save(
                 Payment.builder()
                         .bookingId(request.getBookingId())
                         .userId(booking.getUserId())
                         .amount(request.getAmount())
                         .paymentDate(LocalDateTime.now())
                         .status(PaymentStatus.SUCCESS)
                         .transactionId(UUID.randomUUID().toString()) //UUID Universally Unique Identifier
                         .build()
         );

         return PaymentResponse.builder()
                 .transactionId(payment.getTransactionId())
                 .bookingId(payment.getBookingId())
                 .userId(payment.getUserId())
                 .amount(payment.getAmount())
                 .paymentDate(payment.getPaymentDate())
                 .status(payment.getStatus().name())
                 .message("Payment processed successfully.")
                 .build();
	}

}
