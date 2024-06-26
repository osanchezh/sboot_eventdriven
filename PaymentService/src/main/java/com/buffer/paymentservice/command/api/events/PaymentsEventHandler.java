package com.buffer.paymentservice.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.buffer.commonservice.events.PaymentCancelledEvent;
import com.buffer.commonservice.events.PaymentProcessedEvent;
import com.buffer.paymentservice.command.api.data.Payment;
import com.buffer.paymentservice.command.api.data.PaymentRepository;

import java.util.Date;

@Component
public class PaymentsEventHandler {

    private PaymentRepository paymentRepository;

    public PaymentsEventHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        Payment payment
                = new Payment();
        payment.setPaymentId(event.getPaymentId());
        payment.setOrderId(event.getOrderId());
        payment.setPaymentStatus("COMPLETED");
        payment.setTimeStamp(new Date());

        paymentRepository.save(payment);
    }

    @EventHandler
    public void on(PaymentCancelledEvent event) {
        Payment payment
                = paymentRepository.findById(event.getPaymentId()).get();

        payment.setPaymentStatus(event.getPaymentStatus());

        paymentRepository.save(payment);
    }
}