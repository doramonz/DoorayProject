package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.dto.ProjectMemberDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    public ProjectDto addProject(ProjectDto project);

    public List<ProjectDto> getProjects(String userId);

    public ProjectDto updateProject(Integer projectId, ProjectDto project);

    public String deleteProject(Integer projectId);

    public ProjectDto getProject(Integer projectId);

    public ProjectMemberDto addProjectMemeber(Integer projectId, ProjectMemberDto projectMemberDto);

    public ProjectMemberDto deleteProjectMember(Integer projectId);
}
