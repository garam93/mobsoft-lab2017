package com.example.mobsoft.mobsoft.mock;

import com.example.mobsoft.mobsoft.mock.interceptor.MockInterceptor;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Gabtop on 2017.05.04..
 */

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}