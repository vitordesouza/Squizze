package com.catorze.squizze.domain;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alexandre on 07/08/16.
 */
public class SharedPrefs {

    private static final String APP_PREFERENCES_KEY = "app_preferences";
    private static final String APP_TOKEN_KEY = "token_key";
    private Context mContext;
    private SharedPreferences sharedPreferences;


    public SharedPrefs(Context mContext) {
        this.mContext = mContext;
        this.sharedPreferences = mContext.getSharedPreferences(APP_PREFERENCES_KEY, Context.MODE_PRIVATE);
    }


    public void storeToken(String token) {
        putString(APP_TOKEN_KEY, token);
    }

    public String getToken() {
        return getString(APP_TOKEN_KEY);
    }

    private String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    private void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
