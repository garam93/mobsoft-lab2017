package com.example.mobsoft.mobsoft.ui.details;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.repository.Repository;
import com.example.mobsoft.mobsoft.ui.comment.CommentActivity;
import com.example.mobsoft.mobsoft.ui.details.adapter.CommentClickListener;
import com.example.mobsoft.mobsoft.ui.details.adapter.CommentRVAdapter;
import com.example.mobsoft.mobsoft.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft.ui.main.adapter.NewsRVAdapter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen, CommentClickListener {

    @Inject
    DetailsPresenter detailsPresenter;

    @Inject
    Repository repository;

    @BindView(R.id.detailsTitleTV)
    TextView titleTV;

    @BindView(R.id.detailsAuthorTV)
    TextView authorTV;

    @BindView(R.id.detailsDateTV)
    TextView dateTV;

    @BindView(R.id.detailsUrlTV)
    TextView urlTV;

    @BindView(R.id.detailsDescription)
    TextView descriptionTV;

    @BindView(R.id.detailsImage)
    ImageView imageView;

    @BindView(R.id.commentsView)
    RecyclerView commentsView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private long newsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        MobSoftApplication.injector.inject(this);

        setSupportActionBar(toolbar);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        commentsView.setLayoutManager(manager);

        newsId = this.getIntent().getLongExtra("ID", 0);

        Comment c = new Comment();
        c.setUserId("A");
        //c.setUserName("ASDAS");
        c.setCreationDate(new Date());
        c.setBody("ASDas");
        c.setNewsId(01123l);
        c.setId(new Random().nextLong());
        //comments.add(c);
        repository.saveComment(c);

        News n = repository.getNewsById(newsId);
        if (n != null) {
            titleTV.setText(n.getTitle());

            authorTV.setText(n.getAuthor());
            dateTV.setText(n.getDate());
            urlTV.setText(n.getUrl());
            descriptionTV.setText(n.getDescription());
            Picasso.with(this).load(n.getUrlToImage()).into(imageView);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        boolean loggedIn = prefs.getBoolean("com.example.mobsoft.mobsoft.isLoggedIn", false);
        if (loggedIn) {
            getMenuInflater().inflate(R.menu.menu_login, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu, menu);
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);

        List<Comment> comments = repository.getCommentsByNewsId(newsId);
        CommentRVAdapter adapter = new CommentRVAdapter(comments, this, this);
        commentsView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    public void getDetails(Date date) {
        detailsPresenter.getDetails(date);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.miProfile:
                Intent intent = new Intent();
                intent.setClass(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.miComment:
                Intent intent2 = new Intent();
                intent2.setClass(this, CommentActivity.class);
                intent2.putExtra("ID", newsId);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
