package com.codecool.flexTradeBackEnd.repository;

import com.codecool.flexTradeBackEnd.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByStockCode(String stockCode);
}
