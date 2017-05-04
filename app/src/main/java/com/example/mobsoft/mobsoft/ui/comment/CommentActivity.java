package com.example.mobsoft.mobsoft.ui.comment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.repository.Repository;
import com.example.mobsoft.mobsoft.ui.details.DetailsActivity;
import com.example.mobsoft.mobsoft.ui.login.LoginActivity;

import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentActivity extends AppCompatActivity implements CommentScreen {

    @Inject
    CommentPresenter commentPresenter;

    @Inject
    Repository repository;

    @BindView(R.id.commentText)
    EditText commentET;

    @BindView(R.id.sendCommentBtn)
    Button sendCommentBtn;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private long newsId;
    private final String userId = "USER1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);

        MobSoftApplication.injector.inject(this);
        setSupportActionBar(toolbar);

        newsId = getIntent().getLongExtra("ID", 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
    public boolean createComment(String message, String userId, long newsId) {
        //boolean success = commentPresenter.createComment(message, newsId, userId);

        /*Intent intent = new Intent();
        intent.setClass(this, DetailsActivity.class);
        intent.putExtra("ID", newsId);
        startActivity(intent);*/
        //return success;
        return false;
    }


    @Override
    public void showMessage(String message) {

    }

    @OnClick(R.id.sendCommentBtn)
    public void onSendCommentBtn(){
        commentPresenter.createComment(commentET.getText().toString(), newsId, userId);

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        boolean loggedIn = prefs.getBoolean("com.example.mobsoft.mobsoft.isLoggedIn", false);
        /*if (loggedIn) {
            getMenuInflater().inflate(R.menu.menu_login, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu, menu);
        }*/
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.miProfile:
                break;
            case R.id.miComment:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
