package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.entity.User;
import com.nhnacademy.doorayProject.exeption.LoginFailException;
import com.nhnacademy.doorayProject.service.LoginService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    void getLoginView_withoutSession_status200() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void getLoginView_withSession_status300() throws Exception {
        mockMvc.perform(get("/login").sessionAttr("user", new User()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void postLogin_withoutRequestParam_status200() throws Exception {
        mockMvc.perform(post("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void postLogin_withRequestParamAndFailLogin_status200() throws Exception {
        Mockito.doThrow(new LoginFailException()).when(loginService).login(any());
        mockMvc.perform(post("/login").param("userId", "userId").param("password", "password2"))
                .andExpect(status().isOk());
    }

    @Test
    void postLogin_withRequestParamAndSuccessLogin_status300() throws Exception {
        Mockito.doNothing().when(loginService).login(any());
        mockMvc.perform(post("/login").param("userId", "userId").param("password", "password"))
                .andExpect(status().is3xxRedirection());
    }

}