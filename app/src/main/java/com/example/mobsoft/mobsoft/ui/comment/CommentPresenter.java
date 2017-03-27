package com.example.mobsoft.mobsoft.ui.comment;

import com.example.mobsoft.mobsoft.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class CommentPresenter extends Presenter<CommentScreen> {
    public CommentPresenter(){
    }

    @Override
    public void attachScreen(CommentScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public boolean createComment(String message){
        return true;
    }
}
