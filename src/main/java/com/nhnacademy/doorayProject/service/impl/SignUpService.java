package com.nhnacademy.doorayProject.service.impl;

import com.nhnacademy.doorayProject.adaptor.SignUpAdaptor;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.service.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService implements SignUp {
    private final SignUpAdaptor signUpAdaptor;

    @Override
    public void signUp( RegisterDto registerDto) {
         ResponseEntity<Void> response = signUpAdaptor.signUp(registerDto);
         if(!response.getStatusCode().is2xxSuccessful()) {
//             throw new LoginFailException();
         }
    }
}
