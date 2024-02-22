package com.nhnacademy.doorayProject.controller;

import com.nhnacademy.doorayProject.adapter.LoginAdapter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginAdapter loginAdapter;

    @Test
    void getLogin() {
    }

    @Test
    void postLogin() throws Exception {
        Mockito.when(loginAdapter.login("test", "test")).thenReturn(HttpStatus.OK);
        mockMvc.perform(post("/login").param("userId", "test").param("password", "test"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}