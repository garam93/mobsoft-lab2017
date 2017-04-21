package com.example.mobsoft.mobsoft.repository;
import android.content.Context;

import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.model.Credentials;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<News> getNews() {
        return SugarRecord.listAll(News.class);
    }

    public void saveNews(List<News> news){
        SugarRecord.saveInTx(news);
    }

    @Override
    public void saveComment(Comment comment) {
        SugarRecord.saveInTx(comment);
    }

    @Override
    public List<News> getNewsByDate(Date date) {
        return SugarRecord.listAll(News.class);
    }

    @Override
    public List<Comment> getComments() {
        return SugarRecord.listAll(Comment.class);
    }

    @Override
    public boolean login(Credentials credentials) {
        return false;
    }

}