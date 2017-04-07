package com.example.mobsoft.mobsoft.interactor.login;

import android.net.Credentials;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.login.events.LoginEvent;
import com.example.mobsoft.mobsoft.interactor.news.events.GetCommentsEvent;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class LoginInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public LoginInteractor(){
        MobSoftApplication.injector.inject(this);
    }

    public void login(Credentials credentials){
        LoginEvent event = new LoginEvent();
        try{
            boolean success = repository.login(credentials);
            event.setSuccess(success);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
