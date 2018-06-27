package com.codecool.flexTradeBackEnd.repository;

import com.codecool.flexTradeBackEnd.models.NewsEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntry, Integer> {
}
