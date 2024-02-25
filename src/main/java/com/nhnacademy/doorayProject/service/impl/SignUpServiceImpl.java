package com.nhnacademy.doorayProject.service.Impl;

import com.nhnacademy.doorayProject.adapter.SignUpAdapter;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.exeption.SignUpFailException;
import com.nhnacademy.doorayProject.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final SignUpAdapter signUpAdaptor;

    @Override
    public RegisterDto signUp(RegisterDto registerDto) {
         ResponseEntity<RegisterDto> response = signUpAdaptor.signUp(registerDto);
         if(!response.getStatusCode().is2xxSuccessful()) {
             throw new SignUpFailException();
         }
         return response.getBody();
    }
}
