package com.example.mobsoft.mobsoft.ui.main;

import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends Presenter<MainScreen> {

    public MainPresenter() {
    }


    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public List<String> getNewsList(){
        return new ArrayList<String>();
    }
}