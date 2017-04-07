package com.example.mobsoft.mobsoft.interactor.login.events;

import com.example.mobsoft.mobsoft.model.News;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class LoginEvent {
    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success;
    private Throwable throwable;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
