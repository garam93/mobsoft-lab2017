package com.example.mobsoft.mobsoft.interactor;

import com.example.mobsoft.mobsoft.interactor.comment.CommentInteractor;
import com.example.mobsoft.mobsoft.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

@Module
public class InteractorModule {
    @Provides
    public NewsInteractor provideNews(){
        return new NewsInteractor();
    }

    @Provides
    public CommentInteractor provideComments(){
        return new CommentInteractor();
    }

    @Provides
    public LoginInteractor provideLogin(){ return new LoginInteractor();}
}
