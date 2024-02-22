package com.nhnacademy.doorayProject.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dooray_task")
public class Task {
    public enum Status {
        할일, 진행중, 완료
    }
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    private Integer projectId;
    private String userId;
    private Integer mileStoneId;
    private String taskTitle;
    private String taskContent;
    @Enumerated(EnumType.STRING)
    private Status status;

}
