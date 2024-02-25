package com.nhnacademy.doorayProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentInfoDto {
    private Integer commentId;
    private String userId;
    private Integer taskId;
    private String commentContent;
}
