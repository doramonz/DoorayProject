package com.nhnacademy.doorayProject.adapter;

import com.nhnacademy.doorayProject.dto.CommentInfoListDto;
import org.springframework.http.ResponseEntity;

public interface CommentAdapter {
    ResponseEntity<CommentInfoListDto> getCommentInfo(Integer taskId);
}
