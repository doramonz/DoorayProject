package com.nhnacademy.doorayProject.adaptor;

import com.nhnacademy.doorayProject.dto.*;
import com.nhnacademy.doorayProject.entity.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectAdaptor {

    ResponseEntity<ProjectDto> addProject(ProjectDto project);

    ResponseEntity<List<ProjectDto>> getProjects(String userId);


    ResponseEntity<UpdateProjectResponse> updateProject(Integer projectId, RequestProjectDto project);


    ResponseEntity<String> deleteProject(Integer projectId);

    ResponseEntity<ProjectNameStatusDto> getProject(int projectId);

    ResponseEntity<ProjectMemberDto> addProjectMemeber(Integer projectId,ProjectMemberDto projectMemberDto);

    ResponseEntity<ProjectMemberDto> deleteProjectMember(Integer projectId,ProjectMemberDto projectMemberDto);

}
