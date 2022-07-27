package com.dantesys.soccernews.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {
    @PrimaryKey
    public int id;
    public String title;
    public String text;
    public String img;
    public String link;
    public boolean favorite;

    public News(String title, String text, String img, String link) {
        this.title = title;
        this.text = text;
        this.img = img;
        this.link = link;
    }
}
