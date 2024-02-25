package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.LoginAdapter;
import com.nhnacademy.doorayProject.annotation.Adapter;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.UserIdListDto;
import com.nhnacademy.doorayProject.dto.UserInfoDto;
import com.nhnacademy.doorayProject.dto.UserInfoListDto;
import com.nhnacademy.doorayProject.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Adapter("loginAdapter")
public class LoginAdapterImpl implements LoginAdapter {
    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;

    @Override
    public ResponseEntity<Void> login(UserLoginDto userLoginDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<UserLoginDto> request = new HttpEntity<>(userLoginDto, headers);
        return restTemplate.postForEntity(dataBaseUrl.getAccountAddress() + "/accounts/login", request, Void.class);
    }


}
