package com.catorze.squizze.rest;

import com.catorze.squizze.domain.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by alexandre on 31/07/16.
 */
public interface CategoryService {

    @GET("category")
    Call<List<Category>> get();

}

