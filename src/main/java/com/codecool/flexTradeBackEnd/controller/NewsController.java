package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.models.NewsEntry;
import com.codecool.flexTradeBackEnd.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<List<NewsEntry>> getAllNews(HttpSession session){
        List<NewsEntry> allNews;
        allNews = newsService.getAllNews();
        if (allNews == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allNews, HttpStatus.OK);
        }
    }
}
