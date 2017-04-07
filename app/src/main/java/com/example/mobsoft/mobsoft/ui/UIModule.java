package com.example.mobsoft.mobsoft.ui;

import com.example.mobsoft.mobsoft.interactor.comment.CommentInteractor;
import com.example.mobsoft.mobsoft.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;
import com.example.mobsoft.mobsoft.ui.comment.CommentPresenter;
import com.example.mobsoft.mobsoft.ui.details.DetailsPresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

import android.content.Context;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public CommentPresenter provideCommentPresenter() {
        return new CommentPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() { return new LoginPresenter(); }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }
/*
    @Provides
    @Singleton
    public NewsInteractor provideNewsInteractor() {
        return new NewsInteractor();
    }

    @Provides
    @Singleton
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractor();
    }

    @Provides
    @Singleton
    public CommentInteractor provideCommentInteractor() { return new CommentInteractor(); }
    */

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() { return Executors.newFixedThreadPool(1); }
}