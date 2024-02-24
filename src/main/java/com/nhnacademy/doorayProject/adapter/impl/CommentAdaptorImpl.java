package com.nhnacademy.doorayProject.adapter.impl;

import com.nhnacademy.doorayProject.adapter.CommentAdaptor;
import com.nhnacademy.doorayProject.config.DataBaseUrl;
import com.nhnacademy.doorayProject.dto.CommentDto;
import com.nhnacademy.doorayProject.dto.CommentUpdateDto;
import com.nhnacademy.doorayProject.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentAdaptorImpl implements CommentAdaptor {

    private final RestTemplate restTemplate;

    private final DataBaseUrl dataBaseUrl;

    @Override
    public ResponseEntity<List<Comment>> getComments(Integer taskId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Integer> requestEntity = new HttpEntity<>(taskId, httpHeaders);

        return restTemplate.exchange(dataBaseUrl.getAddress()+"/accounts/register",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<Comment>>() {
                });
    }

    @Override
    public ResponseEntity<CommentDto> registerComment(Integer taskId, CommentDto commentDto) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<CommentDto> requestEntity = new HttpEntity<>(commentDto, httpHeaders);

        return restTemplate.postForEntity(dataBaseUrl.getAddress()+"/projects/tasks/"+taskId+"/comments",
                requestEntity,
                CommentDto.class);
    }

    @Override
    public ResponseEntity<CommentUpdateDto> updateComment(Integer commentId, CommentUpdateDto commentUpdateDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<CommentUpdateDto> response = new HttpEntity<>(commentUpdateDto, headers);

        return restTemplate.exchange(dataBaseUrl.getAddress()+"/accounts/register",
                HttpMethod.PUT,
                response,
                new ParameterizedTypeReference<CommentUpdateDto>() {
                });
    }

    @Override
    public ResponseEntity<Void> removeComment(Integer commentId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Integer> id = new HttpEntity<>(commentId, headers);

        return restTemplate.exchange(dataBaseUrl.getAddress()+"/accounts/register",
                HttpMethod.PUT,
                id,
                new ParameterizedTypeReference<Void>() {
                });
    }


}
