package com.example.mobsoft.mobsoft.ui.comment;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface CommentScreen {
    boolean createComment(String message, String userId, long newsId);
    void showMessage(String message);
}
