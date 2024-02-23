package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.LoginAdapter;
import com.nhnacademy.doorayProject.annotation.Adapter;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        return restTemplate.postForEntity(dataBaseUrl.getAddress() + "/accounts/login", request, Void.class);
    }

}
