package com.nhnacademy.doorayProject.dto;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class RegisterDto {
    private String userId;
    private String password;
    private String userName;
    private String email;
}
