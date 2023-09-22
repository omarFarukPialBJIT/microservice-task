package com.pial.paymentservice.networkmanager;


import com.pial.paymentservice.dto.BookingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service")
public interface BookingFeingClient {
    @GetMapping("/booking/{bookingId}")
    BookingDto bookingById(@PathVariable Long bookingId);
}
