package com.example.mobsoft.mobsoft.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.ui.comment.CommentActivity;
import com.example.mobsoft.mobsoft.ui.details.DetailsActivity;
import com.example.mobsoft.mobsoft.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft.ui.main.adapter.CardClickListener;
import com.example.mobsoft.mobsoft.ui.main.adapter.NewsRVAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreen, CardClickListener {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.mainNewsView)
    RecyclerView mainView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MobSoftApplication.injector.inject(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        setSupportActionBar(toolbar);

        mainView.setLayoutManager(manager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        boolean loggedIn = prefs.getBoolean("com.example.mobsoft.mobsoft.isLoggedIn", false);
        if (!loggedIn) {
            getMenuInflater().inflate(R.menu.menu, menu);
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.getNewsList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getNewsList() {
        mainPresenter.getNewsList();
    }

    @Override
    public void showNews(List<News> news) {
        this.newsList = news;
        NewsRVAdapter adapter = new NewsRVAdapter(news, this, this);
        mainView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        int pos = mainView.getChildLayoutPosition(view);
        News news = newsList.get(pos);

        Intent intent = new Intent();
        intent.setClass(this, DetailsActivity.class);
        intent.putExtra("ID", news.getId());
        startActivity(intent);
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
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        prefs.edit().putBoolean("com.example.mobsoft.mobsoft.isLoggedIn", false).apply();
    }
}