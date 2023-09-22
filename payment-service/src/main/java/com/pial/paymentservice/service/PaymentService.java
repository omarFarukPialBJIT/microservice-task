package com.pial.paymentservice.service;


import com.pial.paymentservice.dto.BookingDto;
import com.pial.paymentservice.dto.PaymentByBookingId;
import com.pial.paymentservice.dto.PaymentDto;
import com.pial.paymentservice.entity.PaymentEntity;
import com.pial.paymentservice.networkmanager.BookingFeingClient;
import com.pial.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    private final BookingFeingClient bookingFeingClient;

    public PaymentService(BookingFeingClient bookingFeingClient) {
        this.bookingFeingClient = bookingFeingClient;
    }

    public void createPayment(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setBookingId(paymentDto.getBookingId());
        paymentEntity.setAmount(paymentEntity.getAmount());
        paymentRepository.save(paymentEntity);
    }

    public List<PaymentEntity> getAllPayment() {
        return paymentRepository.findAll();
    }

    public PaymentByBookingId getPaymentByBookingId(Long bookingId) {
        PaymentEntity paymentByBookingId = paymentRepository.findByBookingId(bookingId);
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setBookingId(paymentByBookingId.getBookingId());
        paymentDto.setAmount(paymentDto.getAmount());

        PaymentByBookingId paymentByBookingId1 = new PaymentByBookingId();
        paymentByBookingId1.setPaymentDto(paymentDto);

        BookingDto bookingDto = bookingFeingClient.bookingById(bookingId);
        paymentByBookingId1.setBookingDto(bookingDto);
        return paymentByBookingId1;


    }


}
