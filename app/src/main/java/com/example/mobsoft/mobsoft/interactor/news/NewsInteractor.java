package com.example.mobsoft.mobsoft.interactor.news;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.comment.events.GetNewsEvent;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class NewsInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public NewsInteractor(){
        MobSoftApplication.injector.inject(this);
    }

    public void getNews(){
        GetNewsEvent event = new GetNewsEvent();
        try{
            List<News> news = repository.getNews();
            event.setNews(news);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }

    }

    public void getNewsByDate(Date date){
        GetNewsEvent event = new GetNewsEvent();
        try{
            List<News> news = repository.getNewsByDate(date);
            event.setNews(news);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
