package com.codecool.flexTradeBackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
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
    private Double workingCapitalRatio;

    @Column(nullable = false)
    private Double earningsPerShare;

    @Column(nullable = false)
    private Double priceEarningsRatio;

    @Column(nullable = false)
    private Double debtEquityRatio;

    @Column(nullable = false)
    private Double returnOnEquity;

    @Column(name = "DATE_FIELD")
    private java.sql.Date dateField;

    @ManyToMany(mappedBy = "stocks")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Stock() { }

    public Stock(String stockCode, String compName, Double workingCapitalRatio, Double earningsPerShare,
                 Double priceEarningsRatio, Double debtEquityRatio, Double returnOnEquity) {
        this.stockCode = stockCode;
        this.compName = compName;
        this.workingCapitalRatio = workingCapitalRatio;
        this.earningsPerShare = earningsPerShare;
        this.priceEarningsRatio = priceEarningsRatio;
        this.debtEquityRatio = debtEquityRatio;
        this.returnOnEquity = returnOnEquity;
        this.dateField = new java.sql.Date(new Date().getTime());
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

    public Double getWorkingCapitalRatio() {
        return workingCapitalRatio;
    }

    public void setWorkingCapitalRatio(Double workingCapitalRatio) {
        this.workingCapitalRatio = workingCapitalRatio;
    }

    public Double getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(Double earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public Double getPriceEarningsRatio() {
        return priceEarningsRatio;
    }

    public void setPriceEarningsRatio(Double priceEarningsRatio) {
        this.priceEarningsRatio = priceEarningsRatio;
    }

    public Double getDebtEquityRatio() {
        return debtEquityRatio;
    }

    public void setDebtEquityRatio(Double debtEquityRatio) {
        this.debtEquityRatio = debtEquityRatio;
    }

    public Double getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(Double returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public java.sql.Date getDateField() {
        return dateField;
    }

    public void setDateField(java.sql.Date dateField) {
        this.dateField = dateField;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
