package com.catorze.squizze.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Quiz;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Alexandre on 17/07/2016.
 */
public class QuizMenuViewAdapter extends RecyclerView.Adapter<QuizMenuViewAdapter.QuizMenuViewHolder> {
    private List<Quiz> quizzes;
    private Context mContext;

    public QuizMenuViewAdapter(List<Quiz> quizzes, Context mContext) {
        this.quizzes = quizzes;
        this.mContext = mContext;
    }

    @Override
    public QuizMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz_menu, parent, false);
        QuizMenuViewHolder quizMenuViewHolder = new QuizMenuViewHolder(view);
        return quizMenuViewHolder;
    }

    @Override
    public void onBindViewHolder(QuizMenuViewHolder holder, int position) {
        Quiz quiz = quizzes.get(position);
        holder.txtName.setText(quiz.getName());
        holder.txtCount.setText(String.valueOf(quiz.getQuestions().size()));
        holder.txtLastResult.setText(MessageFormat.format("{0}%", quiz.getLastResult()));
        holder.txtBestResult.setText(MessageFormat.format("{0}%", quiz.getBestResult()));
    }

    @Override
    public int getItemCount() {
        return this.quizzes.size();
    }

    public class QuizMenuViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtBestResult, txtLastResult, txtCount;
        public QuizMenuViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.quiz_name);
            txtBestResult = (TextView) view.findViewById(R.id.best_result);
            txtLastResult = (TextView) view.findViewById(R.id.last_result);
            txtCount = (TextView) view.findViewById(R.id.count);
        }
    }
}
