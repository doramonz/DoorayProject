package com.nhnacademy.doorayProject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String userId;
    private String password;
    private String userName;
    private String email;
    private LocalDateTime latestLogin;
}
