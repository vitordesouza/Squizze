package com.catorze.squizze.rest;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Category;
import com.catorze.squizze.domain.SharedPrefs;
import com.catorze.squizze.domain.User;
import com.catorze.squizze.domain.dto.AuthCallback;
import com.catorze.squizze.rest.exception.HttpRestException;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alexandre on 31/07/16.
 */
public class LoginRestService extends AbstractRestService {

    private Context mContext;
    private SharedPrefs prefs;

    public LoginRestService(Context mContext) {
        super(mContext);
        this.mContext = mContext;
        this.prefs = new SharedPrefs(mContext);
    }

    public void post(final User user, final OnResponse<AuthCallback> callback) {
        LoginService loginService = (LoginService) initializeRestService(LoginService.class);
        final Call<AuthCallback> call;
        call = loginService.post(user);
        call.enqueue(new Callback<AuthCallback>() {
            @Override
            public void onResponse(Call<AuthCallback> call, Response<AuthCallback> response) {
                AuthCallback authCallback = response.body();
                Log.d("msg", authCallback.toString());
                prefs.storeToken(authCallback.getToken());
                callback.success(authCallback);
            }

            @Override
            public void onFailure(Call<AuthCallback> call, Throwable t) {
                Log.d("msgerro", "deu pau");
                callback.error((HttpRestException) t);
            }
        });
    }

}
