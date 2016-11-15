package com.ex.tainguyen.githuberx.data.entity.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tai.nguyen on 11/14/16.
 */

public class Photo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("liked_by_user")
    @Expose
    private boolean likedByUser;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("current_user_collections")
    @Expose
    private List<Object> currentUserCollections = new ArrayList<Object>();
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = new ArrayList<Object>();
    @SerializedName("links")
    @Expose
    private Links_ links;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return The height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return The color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return The likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @param likes The likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * @return The likedByUser
     */
    public boolean isLikedByUser() {
        return likedByUser;
    }

    /**
     * @param likedByUser The liked_by_user
     */
    public void setLikedByUser(boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The currentUserCollections
     */
    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    /**
     * @param currentUserCollections The current_user_collections
     */
    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    /**
     * @return The urls
     */
    public Urls getUrls() {
        return urls;
    }

    /**
     * @param urls The urls
     */
    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    /**
     * @return The categories
     */
    public List<Object> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    /**
     * @return The links
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

}
