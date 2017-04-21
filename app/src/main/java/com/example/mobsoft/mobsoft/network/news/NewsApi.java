package com.example.mobsoft.mobsoft.network.news;




import com.example.mobsoft.mobsoft.model.Comment;
import com.example.mobsoft.mobsoft.model.News;
import com.example.mobsoft.mobsoft.model.NewsContainer;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NewsApi {

    /**
     *
     * Hírek lekérése
     * @return Call<List<News>>
     */

    @GET("articles?source=the-next-web&sortBy=latest&apiKey=e2992d3c3d2f4175b0a6434d8b85a7bd")
    Call<NewsContainer> newsGet();



    /**
     *
     * Adott dátumhoz tartozó hírek lekérése
     * @param date A kívánt dátum, amelyhez tartozó híreket látni szeretnénk
     * @return Call<List<News>>
     */

    @GET("news/getNewsByDate/{date}")
    Call<List<News>> newsGetNewsByDateDateGet(
            @Path("date") String date
    );


    /**
     *
     * Komment írása
     * @param id A hír azonosítója
     * @param comment Komment szövege
     * @return Call<Void>
     */

    @POST("news/{id}/comment")
    Call<Void> newsIdCommentPost(
            @Path("id") String id, @Body Comment comment
    );


}

