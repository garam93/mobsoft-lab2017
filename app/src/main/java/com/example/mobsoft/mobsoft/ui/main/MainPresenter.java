package com.example.mobsoft.mobsoft.ui.main;

import android.util.Log;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.news.events.GetNewsEvent;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    NewsInteractor newsInteractor;

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    public MainPresenter() {
    }


    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getNewsList() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                newsInteractor.getNews();
            }
        });
    }

    public void onEventMainThread(GetNewsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                /*for(News n : event.getNews()){
                    screen.showMessage(n);;
                }*/
            }
        }
    }

}