package com.nhnacademy.doorayProject.adaptor.impl;

import com.nhnacademy.doorayProject.adaptor.SignUpAdaptor;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SingUpAdaptorImpl implements SignUpAdaptor {

    private final RestTemplate restTemplate;

    private final DataBaseUrl dataBaseUrl;


    public SingUpAdaptorImpl(RestTemplate restTemplate, DataBaseUrl dataBaseUrl) {
        this.restTemplate = restTemplate;
        this.dataBaseUrl = dataBaseUrl;
    }

    @Override
    public ResponseEntity<Void> signUp( RegisterDto registerDto) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<RegisterDto> requestEntity = new HttpEntity<>(registerDto, httpHeaders);

        return restTemplate.exchange(dataBaseUrl+"/accounts",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
