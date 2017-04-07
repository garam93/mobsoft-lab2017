package com.example.mobsoft.mobsoft.interactor.comment.events;

import com.example.mobsoft.mobsoft.model.News;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class GetNewsEvent {
    private int code;
    private List<News> news;
    private Throwable throwable;

    public GetNewsEvent(){

    }

    public GetNewsEvent(int code, List<News> news, Throwable throwable){
        code = code;
        news = news;
        throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
