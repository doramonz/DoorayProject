package com.nhnacademy.doorayProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    @NotEmpty
    String userId;

    @NotEmpty
    String commentContent;
}
