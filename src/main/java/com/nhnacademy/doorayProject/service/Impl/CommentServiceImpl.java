package com.nhnacademy.doorayProject.service.Impl;

import com.nhnacademy.doorayProject.adapter.CommentAdapter;
import com.nhnacademy.doorayProject.detailObject.CommentDetailDo;
import com.nhnacademy.doorayProject.dto.CommentInfoDto;
import com.nhnacademy.doorayProject.dto.CommentInfoListDto;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.service.CommentService;
import com.nhnacademy.doorayProject.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    private final CommentAdapter commentAdapter;
    private final UserInfoService userService;
    @Override
    public List<CommentDetailDo> getComments(Integer taskId) {
        ResponseEntity<CommentInfoListDto> responseEntity = commentAdapter.getCommentInfo(taskId);
        if(!responseEntity.getStatusCode().is2xxSuccessful())
            throw new RuntimeException("Failed to get comments");
        List<CommentInfoDto> commentInfoDtos = responseEntity.getBody().getComments();
        List<String> userIds = commentInfoDtos.stream().map(CommentInfoDto::getUserId).collect(Collectors.toList());
        List<User> userNames = userService.getUserListIn(userIds);

        List<CommentDetailDo> commentDetailDos = new LinkedList<>();
        for(CommentInfoDto commentInfoDto : commentInfoDtos) {
            for(User u : userNames) {
                if(commentInfoDto.getUserId().equals(u.getUserId()))
                    commentDetailDos.add(new CommentDetailDo(commentInfoDto.getCommentId(), commentInfoDto.getUserId(), u.getUserName(), commentInfoDto.getCommentContent()));
            }
        }
        return commentDetailDos;
    }
}
