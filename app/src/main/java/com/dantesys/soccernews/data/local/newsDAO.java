package com.dantesys.soccernews.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.dantesys.soccernews.domain.News;

import java.util.List;

@Dao
public interface newsDAO {
    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news WHERE favorite=1")
    List<News> getFavorites();

    @Query("SELECT * FROM news WHERE news.id=:id")
    News get(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News... news);

    @Delete
    void delete(News news);
}
