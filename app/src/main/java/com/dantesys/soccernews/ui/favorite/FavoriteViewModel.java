package com.dantesys.soccernews.ui.favorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dantesys.soccernews.domain.News;

import java.util.List;

public class FavoriteViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public FavoriteViewModel() {
        this.news = new MutableLiveData<>();
    }
    public LiveData<List<News>> getNews() {
        return this.news;
    }
}