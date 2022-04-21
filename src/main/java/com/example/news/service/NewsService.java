package com.example.news.service;

import com.example.news.client.NewsClient;
import com.example.news.domain.Article;
import com.example.news.domain.Headlines;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsClient newsClient;

    public Headlines getHeadlines() {
        Headlines headlines = newsClient.getHeadlines();
        List<Article> articleList = headlines.getArticles();
        try {
            FileWriter writer = new FileWriter("headlines_description.txt");
            for(var article: articleList) {
                String line = article.getTitle() + " : "
                            + article.getDescription() + " : "
                            + article.getAuthor() + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headlines;
    }

}
