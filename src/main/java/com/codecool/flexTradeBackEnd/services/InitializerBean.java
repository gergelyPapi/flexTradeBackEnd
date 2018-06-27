package com.codecool.flexTradeBackEnd.services;

import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(RegistrationService registrationService,
                           NewsService newsService,
                           StockService stockService) {

        registrationService.registerUser("test1", "test1@gmail.com","123", "Admin");
        registrationService.registerUser("test2", "test2@gmail.com","1234", "User");
        registrationService.registerUser("Sanyi", "test3@gmail.com","12345", "User");
        newsService.createNewNewsEntry("Brexit cancelled",
                "Leaving the EU 'a silly mistake' says May...Gove furious...Johnson still silly...",
                "C4 News");
        newsService.createNewNewsEntry("No news today",
                "Huw Edwards doesn't even have a story about cats",
                "BBC News");
        newsService.createNewNewsEntry("School holidays doubled",
                "Teachers succeed in negotiating a 26 week holiday",
                "CBS News");
        newsService.createNewNewsEntry("Earth Shattering Headline",
                "Certain to change the world, says President",
                "C5 News");
        newsService.createNewNewsEntry("That's one in the eye for King Harold",
                "'That's got to hurt' says Odo | Duke William of Normandy takes the crown | Saxons flee to the hills",
                "Saxon News");
        newsService.createNewNewsEntry("President Assassinated by failed actor",
                "killed in theatre | suspect still at large | tragic end to an incredible career | tributes",
                "Lincoln Dead");

        stockService.createNewStockEntry("AAPL","Apple Inc.",41.12f,2.34f,
                22.12f,10.42f,4.32f);
        stockService.createNewStockEntry("GOOG","Google corp",23.22f,42.34f,
                12.12f,5.42f,5.32f);
        stockService.createNewStockEntry("MSFT","Microsoft Corporation",32.12f,65.34f,
                23.12f,19.42f,10.32f);
        stockService.createNewStockEntry("EC","Ecopetrol S.A.",62.12f,2.34f,
                65.12f,9.42f,4.32f);
        stockService.createNewStockEntry("XOM","Exxon Mobil Corp.",23.12f,2.34f,
                43.12f,5.42f,1.32f);
        stockService.createNewStockEntry("RDS-B","Royal Dutch Shell plc",44.12f,90.34f,
                52.12f,12.42f,2.32f);
        stockService.createNewStockEntry("CVX","Chevron Corporation",23.12f,33.34f,
                32.12f,2.42f,7.32f);
        stockService.createNewStockEntry("JNJ","Johnson & Johnson",62.12f,76.34f,
                12.12f,4.42f,9.32f);
        stockService.createNewStockEntry("PFE","Pfizer Inc.",42.12f,87.34f,
                61.12f,3.42f,15.32f);
    }
}
