package com.nhnacademy.doorayProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.doorayProject.adaptor.SignUpAdaptor;
import com.nhnacademy.doorayProject.controller.SignUpController;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.service.SignUpService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignUpTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private SignUpController controller;

    @Mock
    private SignUpService signUpService;

    @Autowired
    SignUpAdaptor adaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @Order(1)
    void testCreateRegisterDto() throws Exception {
        // when
        RegisterDto registerDto = new RegisterDto("1234","1234","qwer","ss@naver.com");
        ObjectMapper objectMapper = new ObjectMapper();
        // given
        when(signUpService.signUp(registerDto)).thenReturn(registerDto);
        // then
        mockMvc.perform(post("/accounts/register")
                        .content(objectMapper.writeValueAsString(registerDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk());

    }
}
