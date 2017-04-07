package com.example.mobsoft.mobsoft.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
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
}
