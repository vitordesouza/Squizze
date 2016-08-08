package com.catorze.squizze.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alexandre on 07/08/16.
 */
public class User {
    @SerializedName("email")
    private String user;
    @SerializedName("password")
    private String pass;

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public User (){

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
