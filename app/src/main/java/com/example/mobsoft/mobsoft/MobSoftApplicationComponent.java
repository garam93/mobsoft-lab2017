package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.interactor.InteractorModule;
import com.example.mobsoft.mobsoft.interactor.comment.CommentInteractor;
import com.example.mobsoft.mobsoft.interactor.login.LoginInteractor;
import com.example.mobsoft.mobsoft.interactor.news.NewsInteractor;
import com.example.mobsoft.mobsoft.network.NetworkModule;
import com.example.mobsoft.mobsoft.repository.RepositoryModule;
import com.example.mobsoft.mobsoft.ui.UIModule;
import com.example.mobsoft.mobsoft.ui.comment.CommentPresenter;
import com.example.mobsoft.mobsoft.ui.details.DetailsPresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainPresenter mainPresenter);

    void inject(CommentPresenter commentPresenter);

    void inject(DetailsPresenter detailsPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(NewsInteractor newsInteractor);

    void inject(CommentInteractor commentInteractor);

    void inject(LoginInteractor loginInteractor);

}