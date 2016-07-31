package com.catorze.squizze.domain;

import java.util.List;

/**
 * Created by alexandre on 10/07/2016.
 */
public class Quiz {
    private String name;
    private List<Question> questions;
    private float price;
    private int lastResult;
    private int bestResult;
    private int questionCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setLastResult(int lastResult) {
        this.lastResult = lastResult;
    }

    public void setBestResult(int bestResult) {
        this.bestResult = bestResult;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public float getPrice() {
        return price;
    }

    public int getLastResult() {
        return lastResult;
    }

    public int getBestResult() {
        return bestResult;
    }

    public int getQuestionCount() { return questionCount; }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}
