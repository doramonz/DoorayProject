package com.nhnacademy.doorayProject.adaptor;

import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.dto.ProjectMemberDto;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectAdaptor {

    ResponseEntity<ProjectDto> addProject(ProjectDto project);

    ResponseEntity<List<ProjectDto>> getProjects(String userId);


    ResponseEntity<ProjectDto> updateProject(Integer projectId,ProjectDto project);


    ResponseEntity<String> deleteProject(Integer projectId);

    ResponseEntity<ProjectDto> getProject(int projectId);

    ResponseEntity<ProjectMemberDto> addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto);

    ResponseEntity<ProjectMemberDto> deleteProjectMember(Integer projectId);

}
