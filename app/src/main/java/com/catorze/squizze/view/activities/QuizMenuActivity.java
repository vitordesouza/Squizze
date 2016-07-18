package com.catorze.squizze.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Question;
import com.catorze.squizze.domain.Quiz;
import com.catorze.squizze.view.adapter.QuizMenuViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizMenuActivity extends AppCompatActivity {
    private RecyclerView quizMenuRecyclerView;
    private RecyclerView.LayoutManager quizMenuLayoutManager;
    private QuizMenuViewAdapter quizMenuViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
        quizMenuRecyclerView = (RecyclerView) findViewById(R.id.rcvQuiz);
        initRecyclerView(mockQuizzes());
    }

    private List<Quiz> mockQuizzes() {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        Quiz q1 = new Quiz();
        Quiz q2 = new Quiz();

        q1.setName("O quanto você conhece sobre pênises?");
        q1.setBestResult(67);
        q1.setLastResult(55);
        q1.setQuestions(Arrays.asList(new Question()));
        q2.setName("Dig dig joy dig joy popoy");
        q2.setBestResult(78);
        q2.setLastResult(65);
        q2.setQuestions(Arrays.asList(new Question()));
        quizzes.add(q1);
        quizzes.add(q2);
        return quizzes;
    }

    private void initRecyclerView(List<Quiz> quizzes) {
        quizMenuRecyclerView.setHasFixedSize(true);
        quizMenuLayoutManager = new LinearLayoutManager(this);
        quizMenuRecyclerView.setLayoutManager(quizMenuLayoutManager);
        quizMenuViewAdapter = new QuizMenuViewAdapter(quizzes, this);
        quizMenuRecyclerView.setAdapter(quizMenuViewAdapter);
    }
}
