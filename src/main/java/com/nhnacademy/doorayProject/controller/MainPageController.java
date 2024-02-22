package com.nhnacademy.doorayProject.controller;


import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.entity.Project;
import com.nhnacademy.doorayProject.service.ProjectService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController("/projects")
public class MainPageController {

    private final ProjectService service;

    public MainPageController(ProjectService service) {
        this.service = service;
    }

    @PostMapping("/upload")

    public ProjectDto addProjectControll(@RequestBody Project project) {
        return service.addProject(project);
    }

    @PostMapping("/{userId}/list")
    public List<Project> getProjects(@PathVariable String userId) {


        return null;
    }

}
