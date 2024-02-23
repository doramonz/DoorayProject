package com.nhnacademy.doorayProject.service.impl;

import com.nhnacademy.doorayProject.adapter.LoginAdapter;
import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.exeption.LoginFailException;
import com.nhnacademy.doorayProject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private final LoginAdapter loginAdapter;

    @Override
    public void login(UserLoginDto userLoginDto) {
        ResponseEntity<Void> response = loginAdapter.login(userLoginDto);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new LoginFailException();
        }
    }

}
