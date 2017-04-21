package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.model.Credentials;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<News> getNews();

    void saveComment(Comment comment);

    List<News> getNewsByDate(Date date);

    List<Comment> getComments();

    boolean login(Credentials credentials);
    void saveNews(List<News> news);
}
