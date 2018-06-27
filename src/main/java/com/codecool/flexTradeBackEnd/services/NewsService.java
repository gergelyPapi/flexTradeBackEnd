package com.codecool.flexTradeBackEnd.services;


import com.codecool.flexTradeBackEnd.models.NewsEntry;
import com.codecool.flexTradeBackEnd.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public List<NewsEntry> getAllNews() {
        List<NewsEntry> allNews;
        allNews = newsRepository.findAll();
        return allNews;
    }

    public void createNewNewsEntry (String headLine, String description, String source) {
        NewsEntry newNewsEntry = new NewsEntry (headLine, description, source);
        newsRepository.save(newNewsEntry);
    }
}
