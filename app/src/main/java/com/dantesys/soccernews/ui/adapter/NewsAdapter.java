package com.dantesys.soccernews.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dantesys.soccernews.databinding.CardNewBinding;
import com.dantesys.soccernews.domain.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final List<News> news;

    public NewsAdapter(List<News> news) {
        this.news = news;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CardNewBinding biding;
        public ViewHolder(CardNewBinding biding) {
            super(biding.getRoot());
            this.biding = biding;
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardNewBinding binding = CardNewBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = this.news.get(position);
        holder.biding.cnTitle.setText(news.getTitle());
        holder.biding.cnText.setText(news.getText());
    }
    @Override
    public int getItemCount() {
        return this.news.size();
    }
}
