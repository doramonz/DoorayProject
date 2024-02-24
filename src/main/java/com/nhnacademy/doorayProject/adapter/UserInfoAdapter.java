package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.UserInfoDto;
import com.nhnacademy.doorayProject.dto.UserInfoListDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInfoAdapter {
    ResponseEntity<UserInfoDto> getUserInfo(String userId);
    ResponseEntity<UserInfoListDto> getUserListIn(List<String> userIdList);

    ResponseEntity<UserInfoListDto> getUserList();
}
