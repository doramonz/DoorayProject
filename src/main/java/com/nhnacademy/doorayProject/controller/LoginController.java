package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.service.LoginService;
import com.nhnacademy.doorayProject.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;
    private final UserInfoService userInfoService;
    @GetMapping("/login")
    public String getLoginView(@SessionAttribute(name = "userId", required = false) String userId, Model model) {
        if(userId != null) {
            return "redirect:/main";
        }
        model.addAttribute("userLoginDto", new UserLoginDto());
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
        request.getSession(true).setAttribute("userId", userLoginDto.getUserId());

        return "redirect:/main";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        for(Cookie c : request.getCookies()) {
            if(c.getName().equals("JSESSIONID")) {
                c.setMaxAge(0);
            }
        }
        return "redirect:/login";
    }
}
