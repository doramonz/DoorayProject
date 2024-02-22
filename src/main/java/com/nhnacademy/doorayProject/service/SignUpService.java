package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.adaptor.SignUpAdaptor;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final SignUpAdaptor signUpAdaptor;

    public void signUp( RegisterDto registerDto) {
         signUpAdaptor.signUp(registerDto);
    }
}
