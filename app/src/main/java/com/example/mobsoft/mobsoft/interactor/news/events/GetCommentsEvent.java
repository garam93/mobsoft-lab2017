package com.example.mobsoft.mobsoft.interactor.news.events;

import com.example.mobsoft.mobsoft.model.Comment;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class GetCommentsEvent {
    private int code;
    private List<Comment> comments;
    private Throwable throwable;

    public GetCommentsEvent(){

    }

    public GetCommentsEvent(int code, List<Comment> comments, Throwable throwable){
        code = code;
        comments = comments;
        throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
