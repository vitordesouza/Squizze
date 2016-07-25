package com.catorze.squizze.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Category;
import com.catorze.squizze.domain.Question;
import com.catorze.squizze.domain.Quiz;
import com.catorze.squizze.view.adapter.CategoryRecyclerViewHolder;
import com.catorze.squizze.view.adapter.QuizMenuViewAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizMenuActivity extends AppCompatActivity {
    public static final String EXTRA_CATEGORY_JSON = "category_json";

    private RecyclerView quizMenuRecyclerView;
    private RecyclerView.LayoutManager quizMenuLayoutManager;
    private QuizMenuViewAdapter quizMenuViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
        quizMenuRecyclerView = (RecyclerView) findViewById(R.id.rcvQuiz);
        initRecyclerView(deserializeCategory().getQuizzes());
    }

    private Category deserializeCategory() {
        Intent i = getIntent();
        String jsonCategory = i.getStringExtra(EXTRA_CATEGORY_JSON);
        return new Gson().fromJson(jsonCategory, Category.class);
    }

    private void initRecyclerView(List<Quiz> quizzes) {
        quizMenuRecyclerView.setHasFixedSize(true);
        quizMenuLayoutManager = new LinearLayoutManager(this);
        quizMenuRecyclerView.setLayoutManager(quizMenuLayoutManager);
        quizMenuViewAdapter = new QuizMenuViewAdapter(quizzes, this);
        quizMenuRecyclerView.setAdapter(quizMenuViewAdapter);
    }
}
