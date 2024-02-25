package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.dto.TaskInfoDto;
import com.nhnacademy.doorayProject.dto.TaskSimpleInfoDto;

import java.util.List;

public interface TaskService {
    List<TaskSimpleInfoDto> getTaskList(Integer taskId);

    void deleteTask(Integer taskId);

    TaskInfoDto getTaskInfo(Integer taskId);
}
