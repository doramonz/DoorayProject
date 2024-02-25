package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.TaskAdapter;
import com.nhnacademy.doorayProject.annotation.Adapter;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.TaskInfoDto;
import com.nhnacademy.doorayProject.dto.TaskSimpleInfoListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Adapter("taskAdapter")
public class TaskAdapterImpl implements TaskAdapter {
    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;
    @Override
    public ResponseEntity<TaskSimpleInfoListDto> getTaskList(Integer projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(dataBaseUrl.getTaskAddress()+"/projects/"+projectId+"/tasks/list/simple", HttpMethod.GET, entity, TaskSimpleInfoListDto.class);
    }

    @Override
    public ResponseEntity<TaskInfoDto> getTaskInfo(Integer taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(dataBaseUrl.getTaskAddress()+"/projects/tasks/"+taskId, HttpMethod.GET, entity, TaskInfoDto.class);
    }
}
