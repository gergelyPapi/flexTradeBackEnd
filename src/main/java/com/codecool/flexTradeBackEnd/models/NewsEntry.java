package com.codecool.flexTradeBackEnd.models;

import javax.persistence.*;

@Entity
@Table(name = "`news_table`")
public class NewsEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String headLine;

    @Column(unique = true, nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private String source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public NewsEntry() { }

    public NewsEntry(String headLine, String description, String source) {
        this.headLine = headLine;
        this.description = description;
        this.source = source;
    }
}
