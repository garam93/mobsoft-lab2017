package com.example.mobsoft.mobsoft.test;

import com.example.mobsoft.mobsoft.BuildConfig;
import com.example.mobsoft.mobsoft.model.News;
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

import static com.example.mobsoft.mobsoft.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Gabtop on 2017.05.05..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class NewsTest {
    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void testNews() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getNewsList();

        ArgumentCaptor<News> newsCaptor = ArgumentCaptor.forClass(News.class);
        //verify(mainScreen, times(2)).showMessage(todosCaptor.capture());

        List<News> capturedNews = newsCaptor.getAllValues();
        assertEquals(2, capturedNews.size());
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
