package com.example.frontintermedias;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("result")
    private List<User> users = null;

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}