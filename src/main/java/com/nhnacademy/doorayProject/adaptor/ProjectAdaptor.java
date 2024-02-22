package com.nhnacademy.doorayProject.adaptor;

import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.dto.ProjectMemberDto;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectAdaptor {

    ProjectDto addProject(Project project);

    List<Project> getProjects(String userId);


    ProjectDto updateProject(Integer projectId,Project project);


    String deleteProject(Integer projectId);

    Project getProject(int projectId);

    ProjectMemberDto addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto);

    ProjectMemberDto deleteProjectMember(Integer projectId);

}
