package com.ex.tainguyen.githuberx.model;

/**
 * Created by tai.nguyen on 10/27/16.
 */
public class Photo {
    private String id;
    private int width;
    private int height;
    private String color;
    private int likes;
    private String url;

    public Photo(String id, String color, int likes, String url) {
        this.id = id;
        this.color = color;
        this.likes = likes;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
