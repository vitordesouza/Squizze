package com.catorze.squizze.rest;

import android.content.Context;
import android.util.Log;

import com.catorze.squizze.domain.Category;
import com.catorze.squizze.rest.exception.HttpRestException;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by alexandre on 31/07/16.
 */
public class CategoryRestService extends AbstractRestService {

    private Context mContext;

    public CategoryRestService(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    public void get(final AbstractRestService.OnResponse<List<Category>> callback) {
        CategoryService categoryService = (CategoryService) initializeRestService(CategoryService.class);
        final Call<List<Category>> call;
        call = categoryService.get();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.d("tag",  new Gson().toJson(response.body()));
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("tag",  "erro");
                callback.error((HttpRestException) t);

            }
        });
    }

}
