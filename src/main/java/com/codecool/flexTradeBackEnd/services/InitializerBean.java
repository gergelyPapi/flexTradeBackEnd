package com.codecool.flexTradeBackEnd.services;

import org.springframework.stereotype.Component;

@Component

public class InitializerBean {

    public InitializerBean(RegistrationService registrationService,
                           NewsService newsService,
                           StockService stockService,
                           CompanyService companyService) {

        companyService.companyInit();
        newsService.newsEntryInit();
        registrationService.registrationInit();
        stockService.refreshStockData();
    }
}
