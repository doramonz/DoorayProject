package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.entity.User;

import java.util.List;

public interface UserInfoService {
    User getUser(String userId);
    List<User> getUserListIn(List<String> userIdList);
    List<User> getUserList();
}
