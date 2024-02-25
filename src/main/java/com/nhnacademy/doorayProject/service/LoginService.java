package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.entity.User;

import java.util.List;

public interface LoginService {
    void login(UserLoginDto userLoginDto);

}
