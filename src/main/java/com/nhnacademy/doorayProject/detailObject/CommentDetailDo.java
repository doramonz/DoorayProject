package com.nhnacademy.doorayProject.detailObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDetailDo {
    private Integer commentId;
    private String userId;
    private String userName;
    private String content;
}
