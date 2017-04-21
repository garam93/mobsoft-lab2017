package com.example.mobsoft.mobsoft.ui.main;

import com.example.mobsoft.mobsoft.model.News;

import java.util.List;

public interface MainScreen {
    void showMessage(String message);
    void getNewsList();
    void showNews(List<News> news);
}