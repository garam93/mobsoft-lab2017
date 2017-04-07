package com.example.mobsoft.mobsoft.model;

import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

@Table
public class News {
    String id;
    String title;
    String lead;
    String body;
    Date date;
    String coverImageUrl;
    String author;

    public News(){}

    public News(String id, String title, String lead, String body, Date date, String coverImageUrl, String author){
        this.id = id;
        this.title = title;
        this.lead = lead;
        this.body = body;
        this.date = date;
        this.coverImageUrl = coverImageUrl;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
