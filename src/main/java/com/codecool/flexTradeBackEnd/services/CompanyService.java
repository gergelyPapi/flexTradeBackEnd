package com.codecool.flexTradeBackEnd.services;

import com.codecool.flexTradeBackEnd.models.Company;
import com.codecool.flexTradeBackEnd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        List<Company> allCompanyInfo;
        allCompanyInfo = companyRepository.findAll();
        return allCompanyInfo;
    }

    public Company findByStockCode(String stockCompCode) {
        return companyRepository.findByStockCode(stockCompCode);
    }

    public void companyInit() {
        if (this.getAllCompanies().size() <= 0 || this.getAllCompanies() == null) {
            Company bkaa = new Company("BRK-A","Berkshire Hathaway Inc.");
            Company jpm = new Company("JPM","JPMorgan Chase & Co.");
            Company bac = new Company("BAC","Bank of America Corporation");
            Company v = new Company("V","Visa Inc.");
            Company wfc = new Company("WFC","Wells Fargo & Company");
            Company ma = new Company("MA", "Mastercard Incorporated");
            Company hsbc = new Company ("HSBC","HSBC Holdings plc");
            Company c = new Company("C", "Citigroup Inc.");
            Company td = new Company("TD", "The Toronto-Dominion Bank");
            companyRepository.save(bkaa);
            companyRepository.save(jpm);
            companyRepository.save(bac);
            companyRepository.save(v);
            companyRepository.save(wfc);
            companyRepository.save(ma);
            companyRepository.save(hsbc);
            companyRepository.save(c);
            companyRepository.save(td);
        }
    }
}
