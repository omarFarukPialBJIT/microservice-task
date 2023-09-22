package com.pial.bookingservice.networkmanager;

import com.pial.bookingservice.dto.UserDto;
import com.pial.bookingservice.entity.BookingEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserFiengClient {
    @GetMapping("/user/{userId}")
    UserDto userById(@PathVariable Long userId);
}
