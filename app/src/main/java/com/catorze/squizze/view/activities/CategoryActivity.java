package com.catorze.squizze.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Category;
import com.catorze.squizze.domain.Question;
import com.catorze.squizze.domain.Quiz;
import com.catorze.squizze.view.adapter.CategoryAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle(null);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbarCategory);
        setSupportActionBar(topToolBar);


        List<Category> rowListItem = mockCategories();
        lLayout = new GridLayoutManager(CategoryActivity.this, 2);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_category);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        CategoryAdapter rcAdapter = new CategoryAdapter(CategoryActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

    }


    private List<Category> mockCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        Category cat1 = new Category();
        Category cat2 = new Category();

        cat1.setName("Exotic Pussies");
        cat1.setThumbnail("http://www.reactionface.info/sites/default/files/images/1310409026432.jpg");
        cat1.setQuizzes(mockQuizzes("Vagina Let's Go", "Xota Olímpica"));

        cat2.setName("Texugaria");
        cat2.setThumbnail("http://www.imagensparawhats.com/wp-content/uploads/2016/05/13102904_228514474193332_1686338868163118455_n.jpg");
        cat2.setQuizzes(mockQuizzes("Xablau", "Lisador"));

        categories.add(cat1);
        categories.add(cat2);

        return categories;
    }

    private List<Quiz> mockQuizzes(String quizUm, String quizDois) {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        Quiz q1 = new Quiz();
        Quiz q2 = new Quiz();

        q1.setName(quizUm);
        q1.setBestResult(67);
        q1.setLastResult(55);
        q1.setQuestions(Arrays.asList(new Question()));
        q2.setName(quizDois);
        q2.setBestResult(78);
        q2.setLastResult(65);
        q2.setQuestions(Arrays.asList(new Question()));
        quizzes.add(q1);
        quizzes.add(q2);
        return quizzes;
    }

}