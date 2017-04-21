package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.Credentials;
import com.example.mobsoft.mobsoft.model.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60*1000;
    public static List<News> news;
    public static List<Comment> comments;
    @Override
    public void open(Context context) {
        /*
        News news1 = new News(, "Cím", "Lead", "Body", new Date().toString(), "http://google.hu", "Garamvölgyi Gábor");
        News news2 = new News(, "Cím 2", "Lead 2", "Body 2", new Date().toString(), "http://google.hu", "Garamvölgyi Gábor");

        news = new ArrayList<News>();
        news.add(news1);
        news.add(news2);

        Comment c1 = new Comment("Nagyon tetszett", java.util.UUID.randomUUID().toString(), new Date(), news1.getId().toString());
        Comment c2 = new Comment("Nem tetszett", java.util.UUID.randomUUID().toString(), new Date(), news2.getId().toString());
        comments = new ArrayList<Comment>();
        comments.add(c1);
        comments.add(c2);
        */
    }

    @Override
    public void close() {

    }

    @Override
    public List<News> getNews() {
        return news;
    }

    @Override
    public void saveComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<News> getNewsByDate(Date date) {
        List<News> result = new ArrayList<News>();
        for (News n : news){
            if (n.getDate().equals(date)){
                result.add(n);
            }
        }
        return result;
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean login(Credentials credentials) {
        return true;
    }

    @Override
    public void saveNews(List<News> news) {

    }
}
