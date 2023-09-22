package com.pial.userservice.dto;



public class UserDto {

    private Long userId;
    private String name;
    private String location;

    public UserDto() {
    }

    public UserDto(Long userId, String name, String location) {
        this.userId = userId;
        this.name = name;
        this.location = location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
