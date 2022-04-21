package com.example.news.client;

import com.example.news.domain.Headlines;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NewsClient {

    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsClient.class);
    private static final String PATH = "https://newsapi.org/v2/top-headlines?" +
                                       "country=pl&category=business&" +
                                       "apiKey=37d6440c11cf4cdaa9f1bd6c5348338a";

    public Headlines getHeadlines() {
        try {
            return restTemplate.getForObject(PATH, Headlines.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

}
