package com.pial.bookingservice.service;


import com.pial.bookingservice.dto.BookingByUserIdDto;
import com.pial.bookingservice.dto.BookingDto;
import com.pial.bookingservice.dto.UserDto;
import com.pial.bookingservice.entity.BookingEntity;
import com.pial.bookingservice.networkmanager.UserFiengClient;
import com.pial.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    private final UserFiengClient userFiengClient;

    public BookingService(UserFiengClient userFiengClient) {
        this.userFiengClient = userFiengClient;
    }

    public void createBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setUserId(bookingDto.getUserId());
        bookingEntity.setSource(bookingDto.getSource());
        bookingEntity.setDestination(bookingDto.getDestination());
        bookingRepository.save(bookingEntity);
    }

    public List<BookingEntity> getAllBooking() {
        return bookingRepository.findAll();
    }

    public BookingByUserIdDto getBookingByUserId(Long userId) {
        BookingEntity bookingListByUserId = bookingRepository.findByUserId(userId);
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(bookingListByUserId.getBookingId());
        bookingDto.setUserId(bookingListByUserId.getUserId());
        bookingDto.setSource(bookingListByUserId.getSource());
        bookingDto.setDestination(bookingListByUserId.getDestination());

        BookingByUserIdDto bookingByUserIdDto = new BookingByUserIdDto();
        bookingByUserIdDto.setBookingDto(bookingDto);
        UserDto userDto = userFiengClient.userById(userId);
        bookingByUserIdDto.setUserDto(userDto);
        return bookingByUserIdDto;
    }


    public BookingEntity getBookingById(Long bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }
}
