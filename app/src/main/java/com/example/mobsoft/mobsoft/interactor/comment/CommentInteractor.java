package com.example.mobsoft.mobsoft.interactor.comment;

import android.app.usage.UsageEvents;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.news.events.GetCommentsEvent;
import com.example.mobsoft.mobsoft.interactor.news.events.SaveCommentEvent;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class CommentInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public CommentInteractor(){
        MobSoftApplication.injector.inject(this);
    }

    public void getComments(){
        GetCommentsEvent event = new GetCommentsEvent();
        try{
            List<Comment> comments = repository.getComments();
            event.setComments(comments);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveComment(Comment comment){
        SaveCommentEvent event = new SaveCommentEvent();
        event.setComment(comment);
        try{
            repository.saveComment(new Comment());
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
