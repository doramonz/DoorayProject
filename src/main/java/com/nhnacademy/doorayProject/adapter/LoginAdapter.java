package com.nhnacademy.doorayProject.adapter;

import org.springframework.http.HttpStatus;

public interface LoginAdapter {
    HttpStatus login(String userId, String password);
}
