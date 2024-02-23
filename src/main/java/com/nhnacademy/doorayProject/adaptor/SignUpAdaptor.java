package com.nhnacademy.doorayProject.adaptor;

import com.nhnacademy.doorayProject.dto.RegisterDto;
import org.springframework.http.ResponseEntity;


public interface SignUpAdaptor {
    ResponseEntity<Void> signUp(RegisterDto registerDto);
}
