package com.nhnacademy.doorayProject.adaptor;

import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.dto.ProjectMemberDto;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectAdaptor {

    ProjectDto addProject(ProjectDto project);

    List<ProjectDto> getProjects(String userId);


    ProjectDto updateProject(Integer projectId,ProjectDto project);


    String deleteProject(Integer projectId);

    ProjectDto getProject(int projectId);

    ProjectMemberDto addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto);

    ProjectMemberDto deleteProjectMember(Integer projectId);

}
