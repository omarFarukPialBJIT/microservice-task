package com.pial.userservice.controller;


import com.pial.userservice.dto.UserDto;
import com.pial.userservice.entity.UserEntity;
import com.pial.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<?> create (@RequestBody UserDto userDto) {
        try {
            userService.createUser(userDto);
            return new ResponseEntity<>("User created!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/all")
    public ResponseEntity<?> allUser () {
        try {
            List<UserEntity> allUser =  userService.getAllUser();
            return new ResponseEntity<>(allUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> userById (@PathVariable Long userId) {
        try {
            UserEntity user =  userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
