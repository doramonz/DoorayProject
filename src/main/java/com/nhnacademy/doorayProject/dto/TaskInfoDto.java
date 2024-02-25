package com.nhnacademy.doorayProject.dto;

import com.nhnacademy.doorayProject.entity.MileStone;
import com.nhnacademy.doorayProject.entity.Task;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class TaskInfoDto {
    private String title;
    private String content;
    private String createUserId;
    private Task.Status status;
    private LocalDateTime createAt;
    private LocalDateTime endDate;
    private MileStone mileStone;

    public TaskInfoDto(String title, String content, String createUserId, String status, LocalDateTime createAt, LocalDateTime endDate, MileStone mileStone) {
        this.title = title;
        this.content = content;
        this.createUserId = createUserId;
        this.status = Task.Status.valueOf(status);
        this.createAt = createAt;
        this.endDate = endDate;
        this.mileStone = mileStone;
    }

}