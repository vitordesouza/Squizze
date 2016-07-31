package com.catorze.squizze.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Category;
import com.catorze.squizze.domain.Question;
import com.catorze.squizze.domain.Quiz;
import com.catorze.squizze.rest.AbstractRestService;
import com.catorze.squizze.rest.CategoryRestService;
import com.catorze.squizze.rest.exception.HttpRestException;
import com.catorze.squizze.view.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;
    private RecyclerView rView;

    @Override
    protected void onStart() {
        super.onStart();
        CategoryRestService service = new CategoryRestService(this);
        service.get(new AbstractRestService.OnResponse<List<Category>>() {
            @Override
            public void success(List<Category> categories) {
                CategoryAdapter rcAdapter = new CategoryAdapter(CategoryActivity.this, categories);
                rView.setAdapter(rcAdapter);
            }

            @Override
            public void error(HttpRestException restException) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle(null);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbarCategory);
        setSupportActionBar(topToolBar);
        lLayout = new GridLayoutManager(CategoryActivity.this, 2);

        rView = (RecyclerView) findViewById(R.id.recycler_category);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
    }




}