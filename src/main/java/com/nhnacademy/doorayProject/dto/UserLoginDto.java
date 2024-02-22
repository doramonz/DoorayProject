package com.nhnacademy.doorayProject.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLoginDto {
    private String userId;
    private String password;
}
