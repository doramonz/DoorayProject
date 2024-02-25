package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.ProjectAdapter;
import com.nhnacademy.doorayProject.annotation.Adapter;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.ProjectListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Adapter("projectAdapter")
public class ProjectAdapterImpl implements ProjectAdapter {
    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;

    @Override
    public ResponseEntity<ProjectListDto> getProjects(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(dataBaseUrl.getTaskAddress() + "/projects/" + userId+"/list", HttpMethod.GET, request, ProjectListDto.class);
    }
}
