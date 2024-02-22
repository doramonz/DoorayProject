package com.nhnacademy.doorayProject.controller;


import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.entity.Project;
import com.nhnacademy.doorayProject.service.ProjectService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/projects")
public class MainPageController {

    private final ProjectService service;

    public MainPageController(ProjectService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ProjectDto addProject(@RequestBody ProjectDto project) {
        return service.addProject(project);
    }

    @PostMapping("/{userId}/list")
    public List<Project> getProjects(@PathVariable String userId) {


        return null;
    }

}
