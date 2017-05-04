package com.example.mobsoft.mobsoft.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import java.util.Date;
import java.util.Random;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

@Table
public class Comment {
    long id;

    @SerializedName("body")
    String body;

    @SerializedName("userId")
    String userId;

    @SerializedName("creationDate")
    Date creationDate;

    //@SerializedName("userName")
    //String userName;

    @SerializedName("newsId")
    long newsId;

    public Comment() {
    }

    public Comment(String body, String userId, Date creationDate, String name, long newsId) {
        this.id = new Random().nextLong();
        this.body = body;
        this.userId = userId;
        this.creationDate = creationDate;
        this.newsId = newsId;
        //this.userName = name;
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

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

   /* public String getUserName() {
        return userName;
    }*/

/*    public void setUserName(String userName) {
        this.userName = userName;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*public void setFasz(String i){
        this.userName = i;
    }*/

}
