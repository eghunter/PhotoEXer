package com.ex.tainguyen.githuberx.data.entity.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
    public class User {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("portfolio_url")
        @Expose
        private Object portfolioUrl;
        @SerializedName("bio")
        @Expose
        private String bio;
        @SerializedName("location")
        @Expose
        private Object location;
        @SerializedName("total_likes")
        @Expose
        private int totalLikes;
        @SerializedName("total_photos")
        @Expose
        private int totalPhotos;
        @SerializedName("total_collections")
        @Expose
        private int totalCollections;
        @SerializedName("profile_image")
        @Expose
        private ProfileImage profileImage;
        @SerializedName("links")
        @Expose
        private Links links;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         *
         * @param firstName
         * The first_name
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         *
         * @return
         * The lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         *
         * @param lastName
         * The last_name
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         *
         * @return
         * The portfolioUrl
         */
        public Object getPortfolioUrl() {
            return portfolioUrl;
        }

        /**
         *
         * @param portfolioUrl
         * The portfolio_url
         */
        public void setPortfolioUrl(Object portfolioUrl) {
            this.portfolioUrl = portfolioUrl;
        }

        /**
         *
         * @return
         * The bio
         */
        public String getBio() {
            return bio;
        }

        /**
         *
         * @param bio
         * The bio
         */
        public void setBio(String bio) {
            this.bio = bio;
        }

        /**
         *
         * @return
         * The location
         */
        public Object getLocation() {
            return location;
        }

        /**
         *
         * @param location
         * The location
         */
        public void setLocation(Object location) {
            this.location = location;
        }

        /**
         *
         * @return
         * The totalLikes
         */
        public int getTotalLikes() {
            return totalLikes;
        }

        /**
         *
         * @param totalLikes
         * The total_likes
         */
        public void setTotalLikes(int totalLikes) {
            this.totalLikes = totalLikes;
        }

        /**
         *
         * @return
         * The totalPhotos
         */
        public int getTotalPhotos() {
            return totalPhotos;
        }

        /**
         *
         * @param totalPhotos
         * The total_photos
         */
        public void setTotalPhotos(int totalPhotos) {
            this.totalPhotos = totalPhotos;
        }

        /**
         *
         * @return
         * The totalCollections
         */
        public int getTotalCollections() {
            return totalCollections;
        }

        /**
         *
         * @param totalCollections
         * The total_collections
         */
        public void setTotalCollections(int totalCollections) {
            this.totalCollections = totalCollections;
        }

        /**
         *
         * @return
         * The profileImage
         */
        public ProfileImage getProfileImage() {
            return profileImage;
        }

        /**
         *
         * @param profileImage
         * The profile_image
         */
        public void setProfileImage(ProfileImage profileImage) {
            this.profileImage = profileImage;
        }

        /**
         *
         * @return
         * The links
         */
        public Links getLinks() {
            return links;
        }

        /**
         *
         * @param links
         * The links
         */
        public void setLinks(Links links) {
            this.links = links;
        }

    }
