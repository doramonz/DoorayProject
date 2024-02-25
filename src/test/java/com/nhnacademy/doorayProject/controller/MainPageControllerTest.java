package com.nhnacademy.doorayProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.doorayProject.adaptor.ProjectAdaptor;
import com.nhnacademy.doorayProject.dto.ProjectDto;
import com.nhnacademy.doorayProject.service.Impl.ProjectServiceImpl;
import com.nhnacademy.doorayProject.service.ProjectService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainPageControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ProjectServiceImpl service;

    @InjectMocks
    private MainPageController controller;
    @Autowired
    ProjectAdaptor adaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @Order(1)
    void uploadProjectTest()throws Exception {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setName("testProject");
        projectDto.setStatus("할일");

        when(service.addProject(ProjectDto.class.newInstance())).thenReturn(projectDto);


        mockMvc.perform(post("/projects/upload")
                        .content(new ObjectMapper().writeValueAsString(projectDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void restApi() {
        ProjectDto dto = new ProjectDto();
        dto.setProjectId(12);
        dto.setName("testest");
        dto.setStatus("할일");

        adaptor.addProject(dto);
    }
}