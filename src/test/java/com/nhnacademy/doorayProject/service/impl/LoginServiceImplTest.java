package com.nhnacademy.doorayProject.service.impl;

import com.nhnacademy.doorayProject.adapter.LoginAdapter;
import com.nhnacademy.doorayProject.dto.UserLoginDto;
import com.nhnacademy.doorayProject.exeption.UserLoginFailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {
    @Mock
    private LoginAdapter loginAdapter;

    @InjectMocks
    private LoginServiceImpl loginService;

    @Test
    void login_success() {
        UserLoginDto userLoginDto = new UserLoginDto("userId", "password");
        ResponseEntity<Void> response = ResponseEntity.ok().build();
        Mockito.when(loginAdapter.login(userLoginDto)).thenReturn(response);

        Assertions.assertDoesNotThrow(() -> loginService.login(userLoginDto));
        Mockito.verify(loginAdapter).login(userLoginDto);
    }

    @Test
    void login_fail() {
        UserLoginDto loginRequest = new UserLoginDto("userId", "password");
        ResponseEntity<Void> response = ResponseEntity.status(400).build();
        Mockito.when(loginAdapter.login(loginRequest)).thenReturn(response);

        Assertions.assertThrows(UserLoginFailException.class, () -> loginService.login(loginRequest));
        Mockito.verify(loginAdapter).login(loginRequest);
    }
}