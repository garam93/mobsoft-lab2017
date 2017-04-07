package com.example.mobsoft.mobsoft.interactor;

import com.example.mobsoft.mobsoft.interactor.comment.CommentInteractor;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;

import dagger.Module;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

@Module
public class InteractorModule {
    public NewsInteractor provideNews(){
        return new NewsInteractor();
    }

    public CommentInteractor provideComments(){
        return new CommentInteractor();
    }
}
