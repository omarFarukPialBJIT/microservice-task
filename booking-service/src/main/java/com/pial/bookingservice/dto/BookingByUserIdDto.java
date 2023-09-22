package com.pial.bookingservice.dto;

public class BookingByUserIdDto {

    private UserDto userDto;

    private BookingDto bookingDto;

    public BookingByUserIdDto() {
    }

    public BookingByUserIdDto(UserDto userDto, BookingDto bookingDto) {
        this.userDto = userDto;
        this.bookingDto = bookingDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public BookingDto getBookingDto() {
        return bookingDto;
    }

    public void setBookingDto(BookingDto bookingDto) {
        this.bookingDto = bookingDto;
    }
}
