package com.dantesys.soccernews.domain;

public class News {
    private String title;
    private String text;
    private String img;

    public News(String title, String text, String img) {
        this.title = title;
        this.text = text;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public void setText(String text) {
        this.text = text;
    }
}
