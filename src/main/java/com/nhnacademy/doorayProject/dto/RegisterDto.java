package com.nhnacademy.doorayProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
public class RegisterDto {
    private String userId;
    private String password;
    private String userName;
    private String email;
}
