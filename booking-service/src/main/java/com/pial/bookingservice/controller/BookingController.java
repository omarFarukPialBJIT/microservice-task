package com.pial.bookingservice.controller;

import com.pial.bookingservice.dto.BookingByUserIdDto;
import com.pial.bookingservice.dto.BookingDto;
import com.pial.bookingservice.entity.BookingEntity;
import com.pial.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking/create")
    public ResponseEntity<?> create (@RequestBody BookingDto bookingDto) {
        try {
            bookingService.createBooking(bookingDto);
            return new ResponseEntity<>("Booking Done!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/booking/all")
    public ResponseEntity<?> allBooking () {
        try {
            List<BookingEntity> allBooking =  bookingService.getAllBooking();
            return new ResponseEntity<>(allBooking, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<?> bookingById (@PathVariable Long bookingId) {
        try {
            BookingEntity bookingById =  bookingService.getBookingById(bookingId);
            return new ResponseEntity<>(bookingById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/booking/user/{userId}")
    public ResponseEntity<?> bookingByUserId(@PathVariable Long userId) {
        try {
            BookingByUserIdDto bookingByUserIdDto =  bookingService.getBookingByUserId(userId);
            return new ResponseEntity<>(bookingByUserIdDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



}
