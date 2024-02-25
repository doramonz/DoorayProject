package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.dto.TaskInfoDto;
import com.nhnacademy.doorayProject.service.CommentService;
import com.nhnacademy.doorayProject.service.ProjectService;
import com.nhnacademy.doorayProject.service.TaskService;
import com.nhnacademy.doorayProject.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/main")
@RequiredArgsConstructor
@Controller
public class MainController {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final CommentService commentService;
    private final UserInfoService userInfoService;

    @GetMapping
    public String main(Model model, @SessionAttribute("userId") String userId) {
        model.addAttribute("projects", projectService.getProjects(userId));
        return "main/project";
    }

    @GetMapping("/project/{projectId}")
    public String task(@PathVariable("projectId") Integer projectId, Model model) {
        model.addAttribute("tasks", taskService.getTaskList(projectId));
        model.addAttribute("projectId", projectId);
        return "main/task";
    }

    @GetMapping("/project/create")
    public String createProject() {
        return "main/createProject";
    }

    @GetMapping("/project/{projectId}/task/create")
    public String createTask(@PathVariable("projectId") Integer projectId, Model model) {
        model.addAttribute("projectId", projectId);
        return "main/createTask";
    }

    @GetMapping("/project/task/{taskId}/delete")
    public String deleteTask(@PathVariable("taskId") Integer taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/main";
    }

    @GetMapping("/project/{projectId}/delete")
    public String deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
        return "redirect:/main";
    }

    @GetMapping("/project/{projectId}/update")
    public String updateProject(@PathVariable("projectId") Integer projectId, Model model) {
        model.addAttribute("project", projectService.getProjectInfo(projectId));
        return "main/updateProject";
    }

    @GetMapping("/project/task/{taskId}")
    public String viewTask(@PathVariable("taskId") Integer taskId, Model model) {
        model.addAttribute("task", taskService.getTaskInfo(taskId));
        model.addAttribute("userName",userInfoService.getUser(((TaskInfoDto) model.getAttribute("task")).getCreateUserId()).getUserName());
        model.addAttribute("comments", commentService.getComments(taskId));
        return "main/taskView";
    }
}
