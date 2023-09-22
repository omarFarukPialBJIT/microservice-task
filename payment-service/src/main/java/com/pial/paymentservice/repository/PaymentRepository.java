package com.pial.paymentservice.repository;

import com.pial.paymentservice.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    PaymentEntity findByBookingId(Long bookingId);
}
