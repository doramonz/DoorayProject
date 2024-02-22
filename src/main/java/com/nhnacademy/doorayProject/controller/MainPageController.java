package com.nhnacademy.doorayProject.controller;


import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
public class MainPageController {

    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;

    public MainPageController(RestTemplate restTemplate, DataBaseUrl dataBaseUrl) {
        this.restTemplate = restTemplate;
        this.dataBaseUrl = dataBaseUrl;
    }

    @PostMapping("/projects/{userId}/list")
    public List<Project> getProjects(@PathVariable String userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Project>> exchange = restTemplate.exchange(dataBaseUrl.getAddress()
                        + "/projects" + userId + "/list"
                , HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Project>>() {
                });

        return exchange.getBody();
    }

}
