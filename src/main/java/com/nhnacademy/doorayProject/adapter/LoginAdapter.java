package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.UserInfoDto;
import com.nhnacademy.doorayProject.dto.UserInfoListDto;
import com.nhnacademy.doorayProject.dto.UserLoginDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoginAdapter {
    ResponseEntity<Void> login(UserLoginDto userLoginDto);

}
