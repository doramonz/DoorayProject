package com.nhnacademy.doorayProject.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class SignUpExceptionHandler {
    @ExceptionHandler(value = HttpClientErrorException.class)
    public String duplicateUser(HttpClientErrorException e){
        // todo 이미 있으면 로그인 페이지로 이동
        return "redirect:/accounts/register";
    }


    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        return "redirect:/index";
    }
}
