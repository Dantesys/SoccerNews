package com.dantesys.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dantesys.soccernews.R;
import com.dantesys.soccernews.databinding.CardNewBinding;
import com.dantesys.soccernews.domain.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final List<News> news;
    private final FavoriteListener favoriteListener;
    public NewsAdapter(List<News> news,FavoriteListener favoriteListener) {
        this.news = news;
        this.favoriteListener = favoriteListener;
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
        Picasso.get().load(news.img).fit().into(holder.biding.cnImg);
        holder.biding.cnTitle.setText(news.title);
        holder.biding.cnText.setText(news.text);
        Context context = holder.itemView.getContext();
        holder.biding.cnReadmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(news.link);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
        holder.biding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = news.link;
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, R.string.es);
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(intent, ""+R.string.sharing+""));
            }
        });
        holder.biding.favorite.setOnClickListener(view -> {
            news.favorite = !news.favorite;
            this.favoriteListener.onFavorite(news);
            notifyItemChanged(position);
        });
        if(news.favorite){
            holder.biding.favorite.setColorFilter(context.getColor(R.color.favorite));
        }else{
            holder.biding.favorite.setColorFilter(context.getColor(R.color.favorited));
        }
    }
    @Override
    public int getItemCount() {
        return this.news.size();
    }
    public interface FavoriteListener {
        void onFavorite(News news);
    }
}
