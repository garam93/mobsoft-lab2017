package com.example.mobsoft.mobsoft.interactor.news.events;

import com.example.mobsoft.mobsoft.model.Comment;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class SaveCommentEvent {
    private int code;
    private Comment comment;
    private Throwable throwable;

    public SaveCommentEvent(){

    }

    public SaveCommentEvent(int code, Comment comment, Throwable throwable){
        code = code;
        comment = comment;
        throwable = throwable;
    }

    public int getCode(){

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
