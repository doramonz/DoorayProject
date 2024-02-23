package com.nhnacademy.doorayProject.controller;


import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.entity.Project;
import com.nhnacademy.doorayProject.service.Impl.ProjectServiceImpl;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/projects")
public class MainPageController {

    private final ProjectServiceImpl service;

    public MainPageController(ProjectServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String addProject(@RequestBody ProjectDto project) {

        service.addProject(project);
        return null;
    }

    @PostMapping("/{userId}/list")
    public List<Project> getProjects(@PathVariable String userId) {


        return null;
    }

}
