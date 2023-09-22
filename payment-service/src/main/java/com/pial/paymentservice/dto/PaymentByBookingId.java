package com.pial.paymentservice.dto;

public class PaymentByBookingId {

    private BookingDto bookingDto;
    private PaymentDto paymentDto;

    public PaymentByBookingId() {
    }

    public PaymentByBookingId(BookingDto bookingDto, PaymentDto paymentDto) {
        this.bookingDto = bookingDto;
        this.paymentDto = paymentDto;
    }

    public BookingDto getBookingDto() {
        return bookingDto;
    }

    public void setBookingDto(BookingDto bookingDto) {
        this.bookingDto = bookingDto;
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }
}
