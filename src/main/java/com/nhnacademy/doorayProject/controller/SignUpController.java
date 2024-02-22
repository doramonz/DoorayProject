package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.adaptor.SignUpAdaptor;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.service.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts/register")
public class SignUpController {

    private SignUpService signUpService;

    @PostMapping
    public void createAccount(@RequestBody RegisterDto registerDto, Model model) {
        signUpService.signUp(registerDto);
        model.addAttribute("user", registerDto);
    }

}
