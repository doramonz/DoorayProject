package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts/register")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getCreateAccount() {
        return "signUp";
    }

    @PostMapping
    public String createAccount(@ModelAttribute RegisterDto registerDto, Model model) {
        RegisterDto newRegisterDto = signUpService.signUp(registerDto);
        model.addAttribute("user", newRegisterDto);

        return "view";
    }

}
