package com.example.mobsoft.mobsoft;

import android.app.Application;

import com.example.mobsoft.mobsoft.repository.Repository;
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
                        ).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}