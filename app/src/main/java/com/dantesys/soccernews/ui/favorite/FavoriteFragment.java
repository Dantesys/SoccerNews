package com.dantesys.soccernews.ui.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dantesys.soccernews.MainActivity;
import com.dantesys.soccernews.databinding.FragmentFavoriteBinding;
import com.dantesys.soccernews.domain.News;
import com.dantesys.soccernews.ui.adapter.NewsAdapter;

import java.util.List;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoriteViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            List<News> favoriteNews = activity.getDb().newsDao().getFavorites();
            binding.rvfavorites.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvfavorites.setAdapter(new NewsAdapter(favoriteNews, updatedNews -> {
                activity.getDb().newsDao().save(updatedNews);
                MainActivity activity2 = (MainActivity) getActivity();
                if (activity2 != null) {
                    List<News> favoriteNews2 = activity2.getDb().newsDao().getFavorites();
                    binding.rvfavorites.setLayoutManager(new LinearLayoutManager(getContext()));
                    binding.rvfavorites.setAdapter(new NewsAdapter(favoriteNews2, updatedNews2 -> {
                        activity2.getDb().newsDao().save(updatedNews2);
                    }));
                }
            }));
        }
        return  binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}