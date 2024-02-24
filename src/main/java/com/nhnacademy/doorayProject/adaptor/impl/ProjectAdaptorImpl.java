package com.nhnacademy.doorayProject.adaptor.impl;

import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.*;
import com.nhnacademy.doorayProject.entity.Project;
import com.nhnacademy.doorayProject.entity.User;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Component
public class ProjectAdaptorImpl implements ProjectAdaptor {

    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;
    @Autowired
    private HttpServletRequest request;

    private HttpSession session;
    private UserDto user;

    public ProjectAdaptorImpl(RestTemplate restTemplate, DataBaseUrl dataBaseUrl) {
        this.restTemplate = restTemplate;
        this.dataBaseUrl = dataBaseUrl;
         session = request.getSession();
         user = (UserDto) session.getAttribute("user");
    }

    @Override
    public ResponseEntity<ProjectDto> addProject(ProjectDto project) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProjectDto> requestEntity = new HttpEntity<>(project, httpHeaders);

        ResponseEntity<ProjectDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/upload", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ProjectDto>() {
                });

        return exchange;
    }

    @Override
    public ResponseEntity<List<ProjectDto>> getProjects(String userId) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ProjectDto>> exchange = restTemplate.exchange(dataBaseUrl.getAddress()
                        + "/projects/" + userId + "/list"
                , HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<ProjectDto>>() {
                });
        return  exchange;
    }
    //TODO 업데이트 유저 확인 부분 수정 해야함
    //TODO 주소에 userId 넣을것 으로 예상

    @Override
    public ResponseEntity<UpdateProjectResponse> updateProject(Integer projectId, RequestProjectDto project) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<RequestProjectDto> requestEntity = new HttpEntity<>(project,httpHeaders);
        ResponseEntity<UpdateProjectResponse> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId + "/update"+user.getUserId()
                , HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<UpdateProjectResponse>() {
                });
        return exchange;
    }

    @Override
    public ResponseEntity<String> deleteProject(Integer projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<UserDto> requestEntity = new HttpEntity<>(user,httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId + "/delete",
                HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<String>() {
                });
        return exchange;
    }

    @Override
    public ResponseEntity<ProjectNameStatusDto> getProject(int projectId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ProjectNameStatusDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId,
                HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ProjectNameStatusDto>() {
                });

        return exchange;
    }

    @Override
    public ResponseEntity<ProjectMemberDto> addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProjectMemberDto> requestEntity = new HttpEntity<>(projectMemberDto,httpHeaders);

        ResponseEntity<ProjectMemberDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId+"/addMember",
                HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ProjectMemberDto>() {
                });


        return exchange;
    }

    @Override
    public ResponseEntity<ProjectMemberDto> deleteProjectMember(Integer projectId,ProjectMemberDto memberDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectMemberDto> requestEntity = new HttpEntity<>(memberDto,httpHeaders);
        ResponseEntity<ProjectMemberDto> exchange = restTemplate.exchange(dataBaseUrl.getAddress() + "/projects/" + projectId+"/deleteMember",
                HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<ProjectMemberDto>() {
                });


        return exchange;
    }
}
