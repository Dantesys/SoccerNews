package com.dantesys.soccernews.ui.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dantesys.soccernews.domain.News;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();
        //TODO remover esse temp_news para puxar da api
        List<News> temp_news = new ArrayList<News>();
        temp_news.add(new News("Teste","Testagem",""));
        temp_news.add(new News("Teste 2","Testagem alfa",""));
        temp_news.add(new News("Teste 3","Testagem beta",""));
        temp_news.add(new News("Teste 4","Testagem gama",""));
        temp_news.add(new News("Teste 5","Testagem omega",""));
        this.news.setValue(temp_news);
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}