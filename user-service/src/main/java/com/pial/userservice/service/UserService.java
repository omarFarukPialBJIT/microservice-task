package com.pial.userservice.service;


import com.pial.userservice.dto.UserDto;
import com.pial.userservice.entity.UserEntity;
import com.pial.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void createUser(UserDto userDto) throws Exception{
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setLocation(userDto.getLocation());
        userRepository.save(userEntity);

    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long userId) {
        UserEntity user = userRepository.findByUserId(userId);
        return user;
    }
}
