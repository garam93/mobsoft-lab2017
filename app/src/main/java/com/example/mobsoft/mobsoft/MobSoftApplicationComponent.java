package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.ui.UIModule;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}