package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.CommentDto;
import com.nhnacademy.doorayProject.dto.CommentUpdateDto;
import com.nhnacademy.doorayProject.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentAdaptor {
    ResponseEntity<List<Comment>> getComments(Integer taskId);

    ResponseEntity<CommentDto> registerComment(Integer taskId, CommentDto commentDto);

    ResponseEntity<CommentUpdateDto> updateComment(Integer commentId, CommentUpdateDto commentUpdateDto);

    ResponseEntity<Void> removeComment(Integer commentId);
}
