package com.example.news.controller;

import com.example.news.domain.Headlines;
import com.example.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/news")
public class NewsController {

    private final NewsService newsService;

    @RequestMapping(method = RequestMethod.GET, value = "/headlines")
    public ResponseEntity<Headlines> getHeadlines() {
        return ResponseEntity.ok(newsService.getHeadlines());
    }
}
