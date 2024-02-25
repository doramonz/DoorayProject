package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.ProjectListDto;
import org.springframework.http.ResponseEntity;

public interface ProjectAdapter {
    ResponseEntity<ProjectListDto> getProjects(String userId);
}
