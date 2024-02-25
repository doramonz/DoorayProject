package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.CommentAdapter;
import com.nhnacademy.doorayProject.annotation.Adapter;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.CommentInfoListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Adapter("commentAdapter")
public class CommentAdapterImpl implements CommentAdapter {
    private final RestTemplate restTemplate;
    private final DataBaseUrl dataBaseUrl;


    @Override
    public ResponseEntity<CommentInfoListDto> getCommentInfo(Integer taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(dataBaseUrl.getTaskAddress() + "/projects/tasks/" + taskId+"/comments", org.springframework.http.HttpMethod.GET, request, CommentInfoListDto.class);
    }
}
