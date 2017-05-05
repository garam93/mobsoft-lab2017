package com.example.mobsoft.mobsoft.test;

import com.example.mobsoft.mobsoft.BuildConfig;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginScreen;
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

/**
 * Created by Gabtop on 2017.05.05..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginTest {
    private LoginPresenter loginPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        loginPresenter = new LoginPresenter();
    }

    @Test
    public void testNews() {
        LoginScreen loginScreen = mock(LoginScreen.class);
        loginPresenter.attachScreen(loginScreen);
        loginPresenter.login("TEszt", "Teszt");

    }

    @After
    public void tearDown() {
        loginPresenter.detachScreen();
    }
}
