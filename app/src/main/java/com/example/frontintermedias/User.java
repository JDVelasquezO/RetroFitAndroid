package com.example.frontintermedias;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("NAME_USER")
    private String superName;

    public User(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }
}
