package com.example.mobsoft.mobsoft.model;

import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

@Table
public class Comment {
    String body;
    String userId;
    Date creationDate;
    String newsId;

    public Comment(){}

    public Comment(String body, String userId, Date creationDate, String newsId){
        this.body = body;
        this.userId = userId;
        this.creationDate = creationDate;
        this.newsId = newsId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }


}
