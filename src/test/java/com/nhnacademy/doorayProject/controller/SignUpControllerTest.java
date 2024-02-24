package com.nhnacademy.doorayProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.doorayProject.adapter.SignUpAdapter;
import com.nhnacademy.doorayProject.controller.SignUpController;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.service.SignUpService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignUpControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private SignUpController controller;

    @Mock
    private SignUpService signUpService;

    @Autowired
    SignUpAdapter adaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @Order(1)
    void testCreateAccount() throws Exception {
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
    @Test
    void testGetAccount() throws Exception {
        mockMvc.perform(get("/accounts/register"))
                .andExpect(status().isOk());
    }
}
