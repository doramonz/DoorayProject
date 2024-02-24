package com.nhnacademy.doorayProject.service.Impl;

import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
import com.nhnacademy.doorayProject.dto.*;
import com.nhnacademy.doorayProject.entity.Project;
import com.nhnacademy.doorayProject.exeption.*;
import com.nhnacademy.doorayProject.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor adaptor;


    public ProjectServiceImpl(ProjectAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public ProjectDto addProject(ProjectDto project) {
        ResponseEntity<ProjectDto> response = adaptor.addProject(project);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProjectAdditionFailedException();
        }

        return response.getBody();
    }

    public List<ProjectDto> getProjects(String userId) {
        ResponseEntity<List<ProjectDto>> response = adaptor.getProjects(userId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProjectFoundFailedException();
        }
        return response.getBody();
    }

    @Override
    public UpdateProjectResponse updateProject(Integer projectId, RequestProjectDto project) {
        return null;
    }


    public UpdateProjectResponse updateProject(Integer projectId, RequestProjectDto project,String userId) {
        ResponseEntity<UpdateProjectResponse> response = adaptor.updateProject(projectId, project,userId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new IllegalArgumentException();
        }

        return response.getBody();
    }

    public String deleteProject(Integer projectId) {
        ResponseEntity<String> response = adaptor.deleteProject(projectId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProjectDeleteFailedException();
        }
        return response.getBody();
    }

    public ProjectNameStatusDto getProject(Integer projectId) {
        ResponseEntity<ProjectNameStatusDto> response = adaptor.getProject(projectId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProjectFoundFailedException();
        }
        return response.getBody();
    }

    public ProjectMemberDto addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto) {
        ResponseEntity<ProjectMemberDto> response = adaptor.addProjectMemeber(projectId,projectMemberDto);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProjectAddMemberFailedException();
        }
        return response.getBody();
    }



    public ProjectMemberDto deleteProjectMember(Integer projectId,ProjectMemberDto projectMemberDto) {
        ResponseEntity<ProjectMemberDto> response = adaptor.deleteProjectMember(projectId,projectMemberDto);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProjectDeleteMemberFailedException();
        }
        return response.getBody();
    }



}
