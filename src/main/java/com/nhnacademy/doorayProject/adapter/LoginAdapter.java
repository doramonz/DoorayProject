package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.UserLoginDto;
import org.springframework.http.ResponseEntity;

public interface LoginAdapter {
    ResponseEntity<Void> login(UserLoginDto userLoginDto);

}
