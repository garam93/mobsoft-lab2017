package com.example.mobsoft.mobsoft.mock.interceptor;

import android.net.Uri;

import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.network.NetworkConfig;
import com.example.mobsoft.mobsoft.repository.MemoryRepository;
import com.example.mobsoft.mobsoft.utils.GsonHelper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft.mock.interceptor.MockHelper.makeResponse;

/**
 * Created by Gabtop on 2017.05.04..
 */

public class NewsMock {

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "articles?source=the-next-web&sortBy=latest&apiKey=e2992d3c3d2f4175b0a6434d8b85a7bd") && request.method().equals("GET")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getNews());
            responseCode = 200;

            /**
             * Simple Get Example
             */

		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "news/getNewsByDate/{date}") && request.method().equals("GET")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getNews());
			responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "news/{id}/comment") && request.method().equals("POST")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            memoryRepository.saveComment(new Comment());
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}