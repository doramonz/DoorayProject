package com.nhnacademy.doorayProject.service;

import com.nhnacademy.doorayProject.adapter.SignUpAdapter;
import com.nhnacademy.doorayProject.dto.RegisterDto;
import com.nhnacademy.doorayProject.service.impl.SignUpServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignUpServiceTest {
    @Mock
    private SignUpAdapter signUpAdapter;

    @InjectMocks
    private SignUpServiceImpl signUpService;

    @Test
    void testSignUp() {
        RegisterDto registerDto = new RegisterDto("1234","1234","qwer","ww@nhnacademy.com");
        ResponseEntity<RegisterDto> response = ResponseEntity.ok().build();

        when(signUpAdapter.signUp(registerDto)).thenReturn(response);
        Assertions.assertDoesNotThrow(()-> signUpService.signUp(registerDto));

        Mockito.verify(signUpAdapter).signUp(registerDto);
    }
}
