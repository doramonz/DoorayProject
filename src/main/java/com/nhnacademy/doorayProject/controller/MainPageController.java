//package com.nhnacademy.doorayProject.controller;
//
//
//import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
//import com.nhnacademy.doorayProject.dto.*;
//import com.nhnacademy.doorayProject.entity.Project;
//import com.nhnacademy.doorayProject.service.Impl.ProjectServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/projects")
//public class MainPageController {
//
//    private final ProjectServiceImpl service;
//    private final ProjectAdaptor adaptor;
//
//
//    public MainPageController(ProjectServiceImpl service, ProjectAdaptor adaptor) {
//        this.service = service;
//        this.adaptor = adaptor;
//    }
//
//    /**
//     *
//     * @RequestBody부분 thymeleaf 로 html에서 데이터 받을시 @Modelattribute  사용해야함
//     */
//    // TODO 세션으로 교체 요망
//    @PostMapping("/upload")
//    public ProjectDto addProject(@RequestBody ProjectDto project) {
//
//        return service.addProject(project);
//    }
//
//    @PutMapping("/{projectId}/update/{userId}")
//    public UpdateProjectResponse updateProject(@PathVariable Integer projectId, @RequestBody RequestProjectDto projectDto, @PathVariable String userId) {
//        return service.updateProject(projectId, projectDto, userId);
//    }
//
//    @DeleteMapping("/{projectId}/delete")
//    public String deleteProject(@PathVariable Integer projectId) {
//        return service.deleteProject(projectId);
//    }
//
//    @GetMapping("/{projectId}")
//    public ProjectNameStatusDto getProject(@PathVariable Integer projectId) {
//        return service.getProject(projectId);
//    }
//
//    @GetMapping("/{userId}/list")
//    public String getProjects(@PathVariable String userId, Model model) {
//        List<ProjectDto> projectDtos = service.getProjects(userId);
//        model.addAttribute("projectList", projectDtos);
//
//        return "project";
//    }
//    @PostMapping("/{projectId}/addMember")
//    public ProjectMemberDto addMember(@PathVariable Integer projectId, @RequestBody ProjectMemberDto projectMemberDto) {
//        return service.addProjectMemeber(projectId, projectMemberDto);
//    }
//
//    @DeleteMapping("/{projectId}/deleteMember")
//    public ProjectMemberDto deleteMember(@PathVariable Integer projectId, @RequestBody ProjectMemberDto projectMemberDto) {
//        return service.deleteProjectMember(projectId, projectMemberDto);
//    }
//}
