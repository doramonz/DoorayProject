package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.TaskInfoDto;
import com.nhnacademy.doorayProject.dto.TaskSimpleInfoListDto;
import org.springframework.http.ResponseEntity;

public interface TaskAdapter {
    ResponseEntity<TaskSimpleInfoListDto> getTaskList(Integer projectId);

    ResponseEntity<TaskInfoDto> getTaskInfo(Integer taskId);
}
