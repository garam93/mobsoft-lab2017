package com.example.mobsoft.mobsoft;

import android.app.Application;

import com.example.mobsoft.mobsoft.interactor.InteractorModule;
import com.example.mobsoft.mobsoft.network.NetworkModule;
import com.example.mobsoft.mobsoft.repository.Repository;
import com.example.mobsoft.mobsoft.repository.RepositoryModule;
import com.example.mobsoft.mobsoft.ui.UIModule;

import javax.inject.Inject;


public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        )
                        .interactorModule(new InteractorModule())
                        .repositoryModule(new RepositoryModule())
                        .networkModule(new NetworkModule())
                        .build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}