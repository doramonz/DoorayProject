package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.UserLoginRequest;
import org.springframework.http.ResponseEntity;

public interface LoginAdapter {
    ResponseEntity<Void> login(UserLoginRequest userLoginRequest);

}
