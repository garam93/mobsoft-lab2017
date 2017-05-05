package com.example.mobsoft.mobsoft.test;

import com.example.mobsoft.mobsoft.BuildConfig;
import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.ui.comment.CommentPresenter;
import com.example.mobsoft.mobsoft.ui.comment.CommentScreen;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainScreen;
import com.example.mobsoft.mobsoft.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;
import java.util.Random;

import static com.example.mobsoft.mobsoft.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Gabtop on 2017.05.05..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CommentTest {
    private CommentPresenter commentPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        commentPresenter = new CommentPresenter();
    }

    @Test
    public void testNews() {
        CommentScreen commentScreen = mock(CommentScreen.class);
        commentPresenter.attachScreen(commentScreen);
        commentPresenter.createComment("asdas", new Random().nextLong(), "Teszt");

        ArgumentCaptor<Comment> commentsCaptor = ArgumentCaptor.forClass(Comment.class);
        //verify(mainScreen, times(2)).showMessage(todosCaptor.capture());

        List<Comment> capturedComments = commentsCaptor.getAllValues();
        assertEquals(2, capturedComments.size());
    }

    @After
    public void tearDown() {
        commentPresenter.detachScreen();
    }

}
