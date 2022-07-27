package com.dantesys.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dantesys.soccernews.data.remote.soccernewsapi;
import com.dantesys.soccernews.domain.News;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {
    public enum State{
        NOING,DONE,ERROR;
    }
    private final MutableLiveData<State> state = new MutableLiveData<State>();
    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final soccernewsapi api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dantesys.github.io/SoccerNewsAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(soccernewsapi.class);
        this.findNews();
    }
    public void findNews(){
        state.setValue(State.NOING);
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()){
                    news.setValue(response.body());
                    state.setValue(State.DONE);
                }else{
                    state.setValue(State.ERROR);
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                state.setValue(State.ERROR);
            }
        });
    }
    public LiveData<List<News>> getNews() {
        return this.news;
    }
    public LiveData<State> getState() {
        return this.state;
    }
}