package com.example.news.client;

import com.example.news.domain.Headlines;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NewsClientTest {

    @Autowired
    private NewsClient newsClient;

    @Test
    public void articlesSizeTest() {
        //Given
        Headlines headlines = newsClient.getHeadlines();
        //When
        int headlinesSize = headlines.getArticles().size();
        //Then
        assertNotEquals(0, headlinesSize);
    }

    @Test
    public void statusTest() {
        //Given
        Headlines headlines = newsClient.getHeadlines();
        //When
        String status = headlines.getStatus();
        //Then
        assertEquals("ok", status);
    }

    @Test
    public void totalResultsTest() {
        //Given
        Headlines headlines = newsClient.getHeadlines();
        //When
        int totalResults = headlines.getTotalResults();
        //Then
        assertNotEquals(0, totalResults);
    }

}