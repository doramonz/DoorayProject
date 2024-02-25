package com.nhnacademy.doorayProject.service.Impl;

import com.nhnacademy.doorayProject.adapter.LoginAdapter;
import com.nhnacademy.doorayProject.adapter.UserInfoAdapter;
import com.nhnacademy.doorayProject.dto.UserInfoDto;
import com.nhnacademy.doorayProject.dto.UserInfoListDto;
import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.exeption.UserLoginFailException;
import com.nhnacademy.doorayProject.exeption.UserNotFoundException;
import com.nhnacademy.doorayProject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private final LoginAdapter loginAdapter;

    @Override
    public void login(UserLoginDto userLoginDto) {
        ResponseEntity<Void> response = loginAdapter.login(userLoginDto);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new UserLoginFailException();
        }
    }



}
