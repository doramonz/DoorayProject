package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.dto.UserLoginRequest;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.service.LoginService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;
    @GetMapping("/login")
    public String getLoginView(@SessionAttribute(name = "user", required = false) User user) {
        if(user != null) {
            return "redirect:/";
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, @Valid UserLoginRequest userLoginRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "auth/login";
        }
        try {
            loginService.login(userLoginRequest);
        } catch (Exception e) {
            return "auth/login";
        }
        return "redirect:/";
    }
}
