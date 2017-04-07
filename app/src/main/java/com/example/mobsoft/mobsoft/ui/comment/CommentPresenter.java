package com.example.mobsoft.mobsoft.ui.comment;

import android.app.usage.UsageEvents;
import android.util.Log;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.comment.CommentInteractor;
import com.example.mobsoft.mobsoft.interactor.news.events.SaveCommentEvent;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class CommentPresenter extends Presenter<CommentScreen> {

    @Inject
    CommentInteractor commentInteractor;

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    public CommentPresenter(){
    }

    @Override
    public void attachScreen(CommentScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public boolean createComment(String message, String newsId, String creatorId){
        Comment comment = new Comment();
        comment.setBody(message);
        comment.setNewsId(newsId);
        comment.setUserId(creatorId);
        comment.setCreationDate(new Date());
        try{
            commentInteractor.saveComment(comment);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public void onEventMainThread(SaveCommentEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                /*for(Comment c : event.getComment()){
                    screen.showMessage(c.getUserId());;
                }*/
            }
        }
    }
}
