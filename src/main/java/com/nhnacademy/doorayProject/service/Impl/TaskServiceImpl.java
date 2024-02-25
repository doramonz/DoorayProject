package com.nhnacademy.doorayProject.service.Impl;

import com.nhnacademy.doorayProject.adapter.TaskAdapter;
import com.nhnacademy.doorayProject.dto.TaskInfoDto;
import com.nhnacademy.doorayProject.dto.TaskSimpleInfoDto;
import com.nhnacademy.doorayProject.dto.TaskSimpleInfoListDto;
import com.nhnacademy.doorayProject.dto.UserIdListDto;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.service.TaskService;
import com.nhnacademy.doorayProject.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    private final TaskAdapter taskAdapter;
    private final UserInfoService userInfoService;

    @Override
    public List<TaskSimpleInfoDto> getTaskList(Integer taskId) {
        ResponseEntity<TaskSimpleInfoListDto> response = taskAdapter.getTaskList(taskId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new IllegalStateException("Failed to get task list");
        }
        List<TaskSimpleInfoDto> taskSimpleInfoDtos = response.getBody().getTasks();
        List<String> userIds = new LinkedList<>();
        for(TaskSimpleInfoDto taskSimpleInfoDto : taskSimpleInfoDtos) {
            userIds.add(taskSimpleInfoDto.getCreateUserId());
        }
        List<User> users = userInfoService.getUserListIn(userIds);
        for(TaskSimpleInfoDto taskSimpleInfoDto : taskSimpleInfoDtos){
            for(User user : users){
                if(taskSimpleInfoDto.getCreateUserId().equals(user.getUserId())){
                    taskSimpleInfoDto.setCreateUserName(user.getUserName());
                }
            }
        }
        return response.getBody().getTasks();
    }

    @Override
    public void deleteTask(Integer taskId) {

    }

    @Override
    public TaskInfoDto getTaskInfo(Integer taskId) {
        ResponseEntity<TaskInfoDto> response = taskAdapter.getTaskInfo(taskId);
        if(!response.getStatusCode().is2xxSuccessful()){
            throw new IllegalStateException("Failed to get task info");
        }
        return response.getBody();
    }
}
