package com.nhnacademy.doorayProject.controller;


import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.entity.Project;
import com.nhnacademy.doorayProject.service.Impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/projects")
public class MainPageController {

    private final ProjectServiceImpl service;
    private final ProjectAdaptor adaptor;


    public MainPageController(ProjectServiceImpl service, ProjectAdaptor adaptor) {
        this.service = service;
        this.adaptor = adaptor;
    }

    /**
     *
     * @RequestBody부분 thymeleaf 로 html에서 데이터 받을시 @Modelattribute  사용해야함
     *
     */
    @PostMapping("/upload")
    public ProjectDto addProject(@RequestBody ProjectDto project) {


        return service.addProject(project);
    }

    @PostMapping("/{userId}/list")
    public List<Project> getProjects(@PathVariable String userId) {


        return null;
    }

}
