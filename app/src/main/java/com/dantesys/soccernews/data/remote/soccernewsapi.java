package com.dantesys.soccernews.data.remote;

import com.dantesys.soccernews.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface soccernewsapi {
    @GET("news.json")
    Call<List<News>> getNews();
}
