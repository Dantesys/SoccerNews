package com.dantesys.soccernews.ui.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dantesys.soccernews.databinding.CardNewBinding;
import com.dantesys.soccernews.domain.News;
import com.squareup.picasso.Picasso;

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
        Picasso.get().load(news.getImg()).fit().into(holder.biding.cnImg);
        holder.biding.cnTitle.setText(news.getTitle());
        holder.biding.cnText.setText(news.getText());
        holder.biding.cnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(news.getLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return this.news.size();
    }
}
