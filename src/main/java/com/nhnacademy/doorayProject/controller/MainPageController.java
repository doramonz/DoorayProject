package com.nhnacademy.doorayProject.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MainPageController {

//    private final RestTemplate restTemplate;
//
//    public MainPageController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @PostMapping("/projects/{userId}/list")
    public String getProjects(@PathVariable String userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
//        ResponseEntity<List<Project>> exchange =

        return null;
    }

}
