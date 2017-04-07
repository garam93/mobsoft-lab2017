package com.example.mobsoft.mobsoft.ui.details;

import android.util.Log;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.news.events.GetNewsEvent;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {

    @Inject
    NewsInteractor newsInteractor;

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    public DetailsPresenter(){
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getDetails(final Date date) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                newsInteractor.getNewsByDate(date);
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
