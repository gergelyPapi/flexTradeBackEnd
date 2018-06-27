package com.codecool.flexTradeBackEnd.repository;

import com.codecool.flexTradeBackEnd.models.Stock;
import com.codecool.flexTradeBackEnd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findByStockCode(String stockCode);
    List<Stock> findAllByUsers(User user);
}
