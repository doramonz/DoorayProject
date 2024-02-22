package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.dto.ProjectMemberDto;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectAdaptor adaptor;


    public ProjectDto addProject(Project project) {
        return adaptor.addProject(project);
    }
    public ProjectService(ProjectAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    public List<Project> getProjects(String userId) {
        return adaptor.getProjects(userId);
    }

    public ProjectDto updateProject(Integer projectId, Project project) {
        return adaptor.updateProject(projectId, project);
    }

    public String deleteProject(Integer projectId) {
        return adaptor.deleteProject(projectId);
    }

    public Project getProject(Integer projectId) {
        return adaptor.getProject(projectId);
    }

    public ProjectMemberDto addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto) {
        return adaptor.addProjectMemeber(projectId, projectMemberDto);
    }
    public ProjectMemberDto deleteProjectMember(Integer projectId) {
        return adaptor.deleteProjectMember(projectId);
    }



}
