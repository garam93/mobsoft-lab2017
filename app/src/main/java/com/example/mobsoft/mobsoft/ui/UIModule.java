package com.example.mobsoft.mobsoft.ui;

import com.example.mobsoft.mobsoft.ui.main.MainPresenter;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import android.content.Context;


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

}