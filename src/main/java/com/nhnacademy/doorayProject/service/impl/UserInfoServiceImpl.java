package com.nhnacademy.doorayProject.service.impl;

import com.nhnacademy.doorayProject.adapter.UserInfoAdapter;
import com.nhnacademy.doorayProject.dto.UserInfoDto;
import com.nhnacademy.doorayProject.dto.UserInfoListDto;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.exeption.UserNotFoundException;
import com.nhnacademy.doorayProject.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoAdapter userInfoAdapter;

    @Override
    public User getUser(String userId) {
        ResponseEntity<UserInfoDto> response = userInfoAdapter.getUserInfo(userId);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new UserNotFoundException();
        }
        User user = new User();
        user.setUserId(response.getBody().getUserId());
        user.setUserName(response.getBody().getUserName());
        user.setEmail(response.getBody().getEmail());
        return user;
    }

    @Override
    public List<User> getUserListIn(List<String> userIdList) {
        ResponseEntity<UserInfoListDto> response = userInfoAdapter.getUserListIn(userIdList);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new IllegalStateException("Fail to get user list");
        }
        return Objects.requireNonNull(response.getBody()).getUserInfoList().stream().map(userInfoDto -> {
            User user = new User();
            user.setUserId(userInfoDto.getUserId());
            user.setUserName(userInfoDto.getUserName());
            user.setEmail(userInfoDto.getEmail());
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public List<User> getUserList() {
        ResponseEntity<UserInfoListDto> response = userInfoAdapter.getUserList();
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new IllegalStateException("Fail to get user list");
        }
        return Objects.requireNonNull(response.getBody()).getUserInfoList().stream().map(userInfoDto -> {
            User user = new User();
            user.setUserId(userInfoDto.getUserId());
            user.setUserName(userInfoDto.getUserName());
            user.setEmail(userInfoDto.getEmail());
            return user;
        }).collect(Collectors.toList());
    }
}
