package com.nhnacademy.doorayProject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.nhnacademy.account2")
public class TaskAddress {

    private String address;

}
