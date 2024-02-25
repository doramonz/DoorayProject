package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.detailObject.CommentDetailDo;
import com.nhnacademy.doorayProject.dto.CommentInfoDto;

import java.util.List;

public interface CommentService {
    List<CommentDetailDo> getComments(Integer taskId);
}
