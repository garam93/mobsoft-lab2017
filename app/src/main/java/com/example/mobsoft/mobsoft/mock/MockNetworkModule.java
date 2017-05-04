package com.example.mobsoft.mobsoft.mock;

import com.example.mobsoft.mobsoft.network.NetworkModule;
import com.example.mobsoft.mobsoft.network.login.LoginApi;
import com.example.mobsoft.mobsoft.network.news.NewsApi;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by Gabtop on 2017.05.04..
 */

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public NewsApi provideNewsApi(Retrofit retrofit) {
        return networkModule.provideNewsApi(retrofit);
    }

    @Provides
    @Singleton
    public LoginApi privdeLoginApi(Retrofit retrofit) {
        return networkModule.provideLoginApi(retrofit);
    }

}