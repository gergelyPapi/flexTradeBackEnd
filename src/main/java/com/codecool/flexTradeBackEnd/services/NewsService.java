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

    public void newsEntryInit() {
        if (this.getAllNews().size() <= 0 || this.getAllNews() == null) {
            this.createNewNewsEntry("Brexit cancelled",
                    "Leaving the EU 'a silly mistake' says May...Gove furious...Johnson still silly...",
                    "C4 News");
            this.createNewNewsEntry("No news today",
                    "Huw Edwards doesn't even have a story about cats",
                    "BBC News");
            this.createNewNewsEntry("School holidays doubled",
                    "Teachers succeed in negotiating a 26 week holiday",
                    "CBS News");
            this.createNewNewsEntry("Earth Shattering Headline",
                    "Certain to change the world, says President",
                    "C5 News");
            this.createNewNewsEntry("That's one in the eye for King Harold",
                    "'That's got to hurt' says Odo | Duke William of Normandy takes the crown | Saxons flee to the hills",
                    "Saxon News");
            this.createNewNewsEntry("President Assassinated by failed actor",
                    "killed in theatre | suspect still at large | tragic end to an incredible career | tributes",
                    "Lincoln Dead");
        }
    }
}
