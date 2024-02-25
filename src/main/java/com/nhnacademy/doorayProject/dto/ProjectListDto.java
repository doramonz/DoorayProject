package com.nhnacademy.doorayProject.dto;

import com.nhnacademy.doorayProject.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ProjectListDto {
    private List<Project> projects;
}
