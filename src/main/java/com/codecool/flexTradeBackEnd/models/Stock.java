package com.codecool.flexTradeBackEnd.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`stock_table`")
public class Stock {

    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String stockCode;

    @Column(unique = true, nullable = false)
    private String compName;

    @Column(nullable = false)
    private Float workingCapitalRatio;

    @Column(nullable = false)
    private Float earningsPerShare;

    @Column(nullable = false)
    private Float priceEarningsRatio;

    @Column(nullable = false)
    private Float debtEquityRatio;

    @Column(nullable = false)
    private Float returnOnEquity;

    @ManyToMany(mappedBy = "stocks")
    private Set<User> users = new HashSet<>();

    public Stock() { }

    public Stock(String stockCode, String compName, Float workingCapitalRatio, Float earningsPerShare,
                 Float priceEarningsRatio, Float debtEquityRatio, Float returnOnEquity) {
        this.stockCode = stockCode;
        this.compName = compName;
        this.workingCapitalRatio = workingCapitalRatio;
        this.earningsPerShare = earningsPerShare;
        this.priceEarningsRatio = priceEarningsRatio;
        this.debtEquityRatio = debtEquityRatio;
        this.returnOnEquity = returnOnEquity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Float getWorkingCapitalRatio() {
        return workingCapitalRatio;
    }

    public void setWorkingCapitalRatio(Float workingCapitalRatio) {
        this.workingCapitalRatio = workingCapitalRatio;
    }

    public Float getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(Float earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public Float getPriceEarningsRatio() {
        return priceEarningsRatio;
    }

    public void setPriceEarningsRatio(Float priceEarningsRatio) {
        this.priceEarningsRatio = priceEarningsRatio;
    }

    public Float getDebtEquityRatio() {
        return debtEquityRatio;
    }

    public void setDebtEquityRatio(Float debtEquityRatio) {
        this.debtEquityRatio = debtEquityRatio;
    }

    public Float getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(Float returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
