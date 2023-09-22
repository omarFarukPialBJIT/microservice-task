package com.pial.bookingservice.repository;

import com.pial.bookingservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    BookingEntity findByUserId(Long userId);

    BookingEntity findByBookingId(Long bookingId);
}
