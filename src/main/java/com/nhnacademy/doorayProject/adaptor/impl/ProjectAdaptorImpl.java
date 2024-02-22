package com.nhnacademy.doorayProject.adaptor.impl;

import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.dto.ProjectMemberDto;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class ProjectAdaptorImpl implements ProjectAdaptor {

    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;

    public ProjectAdaptorImpl(RestTemplate restTemplate, DataBaseUrl dataBaseUrl) {
        this.restTemplate = restTemplate;
        this.dataBaseUrl = dataBaseUrl;
    }

    @Override
    public ProjectDto addProject(ProjectDto project) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProjectDto> requestEntity = new HttpEntity<>(project, httpHeaders);

        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/upload", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ProjectDto>() {
                });

        return exchange.getBody();
    }

    @Override
    public List<ProjectDto> getProjects(String userId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectDto>> exchange = restTemplate.exchange(dataBaseUrl.getAddress()
                        + "/projects/" + userId + "/list"
                , HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<ProjectDto>>() {
                });
        return  exchange.getBody();
    }

    @Override
    public ProjectDto updateProject(Integer projectId,ProjectDto project) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectDto> requestEntity = new HttpEntity<>(project,httpHeaders);
        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId + "/update"
                , HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<ProjectDto>() {
                });
        return exchange.getBody();
    }

    @Override
    public String deleteProject(Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId + "/delete",
                HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<String>() {
                });
        return exchange.getBody();
    }

    @Override
    public ProjectDto getProject(int projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId,
                HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ProjectDto>() {
                });

        return exchange.getBody();
    }

    @Override
    public ProjectMemberDto addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProjectMemberDto> requestEntity = new HttpEntity<>(projectMemberDto,httpHeaders);

        ResponseEntity<ProjectMemberDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId+"/addMember",
                HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ProjectMemberDto>() {
                });


        return exchange.getBody();
    }

    @Override
    public ProjectMemberDto deleteProjectMember(Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ProjectMemberDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId+"/deleteMember",
                HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<ProjectMemberDto>() {
                });


        return exchange.getBody();
    }
}
