package com.example.news.controller;

import com.example.news.domain.Headlines;
import com.example.news.service.NewsService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@SpringJUnitWebConfig
@WebMvcTest(NewsController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsService newsService;

    @Test
    public void controllerTest() throws Exception {
        //Given
        Headlines headlines = Headlines.builder()
                                       .status("ok")
                                       .totalResults(5)
                                       .articles(new ArrayList<>())
                                       .build();
        //When
        Mockito.when(newsService.getHeadlines()).thenReturn(headlines);
        //Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/news/headlines")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().is(200))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is("ok")))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.totalResults", Matchers.is(5)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.articles", Matchers.hasSize(0)));
    }
}