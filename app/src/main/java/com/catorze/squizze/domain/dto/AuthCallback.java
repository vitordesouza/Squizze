package com.catorze.squizze.domain.dto;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alexandre on 07/08/16.
 */
public class AuthCallback {
    @SerializedName("APP-TOKEN")
    private String token;

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
