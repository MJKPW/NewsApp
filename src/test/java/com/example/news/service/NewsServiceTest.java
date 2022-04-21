package com.example.news.service;

import com.example.news.client.NewsClient;
import com.example.news.domain.Headlines;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class NewsServiceTest {

    @InjectMocks
    private NewsService newsService;

    @Mock
    private NewsClient newsClient;


    @Test
    public void serviceTest() {
        //Given
        Headlines headlines = Headlines.builder()
                                       .status("ok")
                                       .totalResults(5)
                                       .articles(new ArrayList<>())
                                       .build();
        //When
        Mockito.when(newsClient.getHeadlines()).thenReturn(headlines);
        Headlines result = newsService.getHeadlines();
        //Then
        assertEquals(0, result.getArticles().size());
        assertEquals("ok", result.getStatus());
        assertEquals(5, result.getTotalResults());
    }
}