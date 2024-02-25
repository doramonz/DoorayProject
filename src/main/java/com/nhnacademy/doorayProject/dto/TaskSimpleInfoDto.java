package com.nhnacademy.doorayProject.dto;

import com.nhnacademy.doorayProject.entity.Task;
import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class TaskSimpleInfoDto {
    private Integer taskId;
    private String title;
    private String createUserId;
    private Task.Status status;
    private String createUserName;
    public TaskSimpleInfoDto(Integer taskId, String title, String createUserId, String staus, String createUserName) {
        this.taskId = taskId;
        this.title = title;
        this.createUserId = createUserId;
        this.status = Task.Status.valueOf(staus);
        this.createUserName = createUserName;
    }
}