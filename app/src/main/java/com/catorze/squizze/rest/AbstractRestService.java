package com.catorze.squizze.rest;

import com.catorze.squizze.rest.exception.HttpRestException;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by alexandre on 31/07/16.
 */
public class AbstractRestService {

    private static final String BASE_URL = "http://192.168.1.42:3000/";
    //    private static final String BASE_URL = "http://www.mocky.io/v2/";
    private Retrofit retrofit;


    public Object initializeRestService(Class clazz) {

        OkHttpClient.Builder client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                if (response.code() >= 400)
                    throw new HttpRestException(response.message(), response.code());

                return response;
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        return retrofit.create(clazz);
    }

    public interface OnResponse<T>{
        void success(T t);
        void error(HttpRestException restException);
    }
}
