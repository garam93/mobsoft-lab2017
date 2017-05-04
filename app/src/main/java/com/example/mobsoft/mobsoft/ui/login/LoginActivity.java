package com.example.mobsoft.mobsoft.ui.login;

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
import android.widget.TextView;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.ui.details.DetailsActivity;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity  implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.loginUserNameEdit)
    EditText usernameET;

    @BindView(R.id.loginPasswordEdit)
    EditText passwordET;

    @BindView(R.id.loginBtn)
    Button btn;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        MobSoftApplication.injector.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void login(String username, String password) {
        loginPresenter.login(username, password);
    }

    @Override
    public void showMessage(String message) {

    }

    @OnClick(R.id.loginBtn)
    public void onClickLoginBtn(){
        String login = usernameET.getText().toString();
        String pw = passwordET.getText().toString();

        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        prefs.edit().putString("com.example.mobsoft.mobsoft.userName", login).apply();
        prefs.edit().putBoolean("com.example.mobsoft.mobsoft.isLoggedIn", true).apply();

        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
