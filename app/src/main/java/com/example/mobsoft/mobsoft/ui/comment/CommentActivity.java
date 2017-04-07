package com.example.mobsoft.mobsoft.ui.comment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mobsoft.mobsoft.model.Comment;

import java.util.Date;

import javax.inject.Inject;

public class CommentActivity extends AppCompatActivity implements CommentScreen {

    @Inject
    CommentPresenter commentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_comment);

    }

    @Override
    protected void onStart() {
        super.onStart();
        commentPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        commentPresenter.detachScreen();
    }

    @Override
    public boolean createComment(String message, String userId, String newsId) {
        return commentPresenter.createComment(message, newsId, userId);
    }


    @Override
    public void showMessage(String message) {

    }
}
