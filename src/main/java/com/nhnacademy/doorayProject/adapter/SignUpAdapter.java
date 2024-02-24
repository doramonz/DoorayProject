package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.RegisterDto;
import org.springframework.http.ResponseEntity;


public interface SignUpAdapter {
    ResponseEntity<RegisterDto> signUp(RegisterDto registerDto);
}
