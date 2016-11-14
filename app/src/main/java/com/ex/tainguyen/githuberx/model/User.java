package com.ex.tainguyen.githuberx.model;

/**
 * Created by tai.nguyen on 10/27/16.
 */
public class User {
    private String id;
    private String name;

    public User(String id, String userName) {
        this.id = id;
        name = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
