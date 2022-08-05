package com.example.frontintermedias;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class Assign {

    @SerializedName("dpi_user")
    private int dpi_user;

    @SerializedName("code_course")
    private int code_course;

    public int getDpi_user() {
        return dpi_user;
    }

    public void setDpi_user(int dpi_user) {
        this.dpi_user = dpi_user;
    }

    public int getCode_course() {
        return code_course;
    }

    public void setCode_course(int code_course) {
        this.code_course = code_course;
    }
}
