package com.example.mobsoft.mobsoft.ui.login;

import android.util.Log;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft.interactor.login.events.LoginEvent;
import com.example.mobsoft.mobsoft.interactor.news.events.GetNewsEvent;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;
import com.example.mobsoft.mobsoft.model.Credentials;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;


public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    LoginInteractor loginInteractor;

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    public LoginPresenter(){
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void login(String username, String password){
        final Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                loginInteractor.login(credentials);
            }
        });
    }

    public void onEventMainThread(LoginEvent event) {
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
