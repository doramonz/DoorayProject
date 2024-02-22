package com.nhnacademy.doorayproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "dooray_project")
public class Project {


    @Id
    @Column(name = "project_id")
    private int projectId;

    private String name;

    private String status;
}
