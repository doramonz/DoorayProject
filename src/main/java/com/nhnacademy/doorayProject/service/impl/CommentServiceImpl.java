package com.nhnacademy.doorayProject.service.impl;

import com.nhnacademy.doorayProject.adapter.CommentAdaptor;
import com.nhnacademy.doorayProject.dto.CommentDto;
import com.nhnacademy.doorayProject.dto.CommentUpdateDto;
import com.nhnacademy.doorayProject.entity.Comment;
import com.nhnacademy.doorayProject.exeption.CommentsFailException;
import com.nhnacademy.doorayProject.exeption.LoginFailException;
import com.nhnacademy.doorayProject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentAdaptor commentAdaptor;
    @Override
    public List<Comment> getComments(Integer taskId) {
        ResponseEntity<List<Comment>> response = commentAdaptor.getComments(taskId);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new CommentsFailException();
        }
        return response.getBody();

    }

    @Override
    public CommentDto postComment(Integer taskId, CommentDto commentDto) {
        ResponseEntity<CommentDto> response = commentAdaptor.registerComment(taskId,commentDto);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new CommentsFailException();
        }
        return response.getBody();
    }

    @Override
    public CommentUpdateDto updateCommemt(Integer commentId, CommentUpdateDto commentUpdateDto) {
        ResponseEntity<CommentUpdateDto> response = commentAdaptor.updateComment(commentId,commentUpdateDto);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new CommentsFailException();
        }
        return response.getBody();
    }

    @Override
    public void deleteComment(Integer commentId) {
        ResponseEntity<Void> response = commentAdaptor.removeComment(commentId);
        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new CommentsFailException();
        }
    }

}
