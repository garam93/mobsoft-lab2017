package com.example.mobsoft.mobsoft.interactor.news;

import android.util.Log;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.news.events.GetNewsEvent;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.model.NewsContainer;
import com.example.mobsoft.mobsoft.network.news.NewsApi;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class NewsInteractor implements Callback<NewsContainer> {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    NewsApi newsApi;

    public NewsInteractor(){
        MobSoftApplication.injector.inject(this);
    }

    public void getNews(){
        GetNewsEvent event = new GetNewsEvent();
        try {
            NewsContainer body = newsApi.newsGet().execute().body();
            List<News> news = body.getArticles();
            for (News n: news) {
                final long id = new Random().nextLong();
                n.setId(id);
            }
            event.setNews(news);
            repository.saveNews(news);
            bus.post(event);

        }
        catch(Exception e){
            Log.v("Aaa", e.getMessage());
            event.setThrowable(e);
            bus.post(event);
        }
        /*GetNewsEvent event = new GetNewsEvent();
        try{
            //List<News> news = repository.getNews();
            newsApi.newsGet();
            //event.setNews(news);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }*/

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

    @Override
    public void onResponse(Response<NewsContainer> response) {
        GetNewsEvent event = new GetNewsEvent();
        try{
            //List<News> news = repository.getNews();
            NewsContainer newsContainer = response.body();
            List<News> news = newsContainer.getArticles();
            repository.saveNews(news);
            event.setNews(news);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.v(
                "aa", t.getMessage()
        );
    }
}
