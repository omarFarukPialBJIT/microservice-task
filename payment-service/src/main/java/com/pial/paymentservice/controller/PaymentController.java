package com.pial.paymentservice.controller;


import com.pial.paymentservice.dto.PaymentByBookingId;
import com.pial.paymentservice.dto.PaymentDto;
import com.pial.paymentservice.entity.PaymentEntity;
import com.pial.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {


    @Autowired
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    public ResponseEntity<?> create (@RequestBody PaymentDto paymentDto) {
        try {
            paymentService.createPayment(paymentDto);
            return new ResponseEntity<>("Payment Done!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/payment/all")
    public ResponseEntity<?> allPayment () {
        try {
            List<PaymentEntity> allPayment =  paymentService.getAllPayment();
            return new ResponseEntity<>(allPayment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/payment/booking/{bookingId}")
    public ResponseEntity<?> paymentByBookingId(@PathVariable Long bookingId) {
        try {
            PaymentByBookingId paymentByBookingId =  paymentService.getPaymentByBookingId(bookingId);
            return new ResponseEntity<>(paymentByBookingId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



}
