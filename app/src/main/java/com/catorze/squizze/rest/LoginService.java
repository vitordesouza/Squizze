package com.catorze.squizze.rest;

import com.catorze.squizze.domain.User;
import com.catorze.squizze.domain.dto.AuthCallback;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by alexandre on 07/08/16.
 */
public interface LoginService {

    @POST("account/login")
    Call<AuthCallback> post(@Body User user);

}
