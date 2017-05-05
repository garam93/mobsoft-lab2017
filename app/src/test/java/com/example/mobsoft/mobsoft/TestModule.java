package com.example.mobsoft.mobsoft;

import android.content.Context;
import android.util.Log;

import com.example.mobsoft.mobsoft.ui.comment.CommentPresenter;
import com.example.mobsoft.mobsoft.ui.details.DetailsPresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import com.example.mobsoft.mobsoft.ui.UIModule;

/**
 * Created by Gabtop on 2017.05.05..
 */

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }
    @Provides
    public DetailsPresenter provideDetailsPresenter() {
        return UIModule.provideDetailsPresenter();
    }@Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }@Provides
    public CommentPresenter provideCommentPresenter() {
        return UIModule.provideCommentPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}