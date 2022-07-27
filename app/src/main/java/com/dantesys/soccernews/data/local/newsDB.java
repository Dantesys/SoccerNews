package com.dantesys.soccernews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dantesys.soccernews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class newsDB extends RoomDatabase {
    public abstract newsDAO newsDao();
}
