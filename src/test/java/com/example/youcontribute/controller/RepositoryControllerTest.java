package com.example.youcontribute.controller;

import com.example.youcontribute.controller.requests.CreateRepositoryRequest;
import com.example.youcontribute.controller.resources.RepositoryResource;
import com.example.youcontribute.service.RepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RepositoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RepositoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RepositoryService repositoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreate_itShouldReturnList() throws Exception {

        RepositoryResource repository1 = RepositoryResource.builder()
                .organization("test")
                .name("repository")
                .build();

        RepositoryResource repository2 = RepositoryResource.builder()
                .organization("test")
                .name("repository")
                .build();

        List<RepositoryResource> list = new ArrayList<>();
        list.add(repository1);
        list.add(repository2);



        given(this.repositoryService.list()).willReturn(list);

        mockMvc
                .perform(get("/repositories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("repository"))
                .andExpect(jsonPath("$[0].organization").value("test"));

    }



    @Test
    public void testCreate_itShouldCreateRepository() throws Exception {


        CreateRepositoryRequest request = CreateRepositoryRequest.builder()
                .repository("repository")
                .organization("organization")
                .build();

        doNothing().when(this.repositoryService).create(request);


        mockMvc
                .perform(post("/repositories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andDo(print())
                .andExpect(status().isCreated());


    }




}