package com.dantesys.soccernews.domain;

public class News {
    private String title;
    private String text;
    private String img;
    private String link;
    public News(String title, String text, String img, String link) {
        this.title = title;
        this.text = text;
        this.img = img;
        this.link = link;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
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
