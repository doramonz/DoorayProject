package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.service.LoginService;
import com.nhnacademy.doorayProject.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final UserInfoService userInfoService;
    @GetMapping("/login")
    public String getLoginView(@SessionAttribute(name = "user", required = false) User user) {
        if(user != null) {
            return "redirect:/";
        }
        return "login/login";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, @Valid UserLoginDto userLoginDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "login/login";
        }
        try {
            loginService.login(userLoginDto);
        } catch (Exception e) {
            return "login/login";
        }
        //todo 여기에 로그인 성공시 UserInfoDto 받아와서 세션에 추가하는 코드 추가
        User user = userInfoService.getUser(userLoginDto.getUserId());
        request.getSession(true).setAttribute("user", user);

        return "redirect:/";
    }
}
