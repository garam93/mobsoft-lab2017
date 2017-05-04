package com.example.mobsoft.mobsoft.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

@Table
public class NewsContainer {

    @SerializedName("articles")
    List<News> articles;

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
