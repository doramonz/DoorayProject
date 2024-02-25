package com.nhnacademy.doorayProject.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLoginDto {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;
}
