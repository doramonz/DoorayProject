package com.nhnacademy.doorayProject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private String userId;
    private String password;
    private String userName;
    private String email;

    private LocalDateTime latestLogin;
}
