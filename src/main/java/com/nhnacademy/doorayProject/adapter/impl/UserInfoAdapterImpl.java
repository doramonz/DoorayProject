package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.UserInfoAdapter;
import com.nhnacademy.doorayProject.annotation.Adapter;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.UserIdListDto;
import com.nhnacademy.doorayProject.dto.UserInfoDto;
import com.nhnacademy.doorayProject.dto.UserInfoListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RequiredArgsConstructor
@Adapter("userInfoAdapter")
public class UserInfoAdapterImpl implements UserInfoAdapter {
    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;

    @Override
    public ResponseEntity<UserInfoDto> getUserInfo(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(dataBaseUrl.getAccountAddress() + "/accounts/" + userId, HttpMethod.GET, request, UserInfoDto.class);
    }

    @Override
    public ResponseEntity<UserInfoListDto> getUserListIn(List<String> userIdList) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<UserIdListDto> request = new HttpEntity<>(new UserIdListDto(userIdList), headers);
        return restTemplate.postForEntity(dataBaseUrl.getAccountAddress() + "/accounts/list", request, UserInfoListDto.class);
    }

    @Override
    public ResponseEntity<UserInfoListDto> getUserList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(dataBaseUrl.getAccountAddress() + "/accounts/list", HttpMethod.GET, request, UserInfoListDto.class);
    }
}
