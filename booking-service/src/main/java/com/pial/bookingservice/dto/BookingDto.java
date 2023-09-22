package com.pial.bookingservice.dto;

public class BookingDto {
    private Long bookingId;
    private Long userId;
    private String source;
    private String destination;

    public BookingDto() {
    }

    public BookingDto(Long bookingId, Long userId, String source, String destination) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
