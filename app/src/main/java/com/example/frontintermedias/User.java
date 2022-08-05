package com.example.frontintermedias;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class User {

    @SerializedName("NAME_USER")
    private String superName;

    @SerializedName("DPI")
    private int dpi;

    @SerializedName("PHONE")
    private String phone;

    @SerializedName("EMAIL")
    private String email;

    @SerializedName("PASS")
    private String pass;

    public User(int dpi, String name, String email, String pass, String phone) {
        this.dpi = dpi;
        this.superName = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public String getName() {
        return superName;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
