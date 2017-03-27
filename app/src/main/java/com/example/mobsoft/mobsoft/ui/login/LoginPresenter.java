package com.example.mobsoft.mobsoft.ui.login;

import com.example.mobsoft.mobsoft.ui.Presenter;


public class LoginPresenter extends Presenter<LoginScreen> {
    public LoginPresenter(){
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public boolean login(String username, String password){
        return true;
    }
}
