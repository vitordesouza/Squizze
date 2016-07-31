package com.catorze.squizze.domain;

import java.util.List;

/**
 * Created by alexandre on 24/07/16.
 */
public class Category {

    private String name;
    private List<Quiz> quizzes;
    private String thumbnail;
    private int photo;
    private Requirement requirements;

    public Category() {

    }

    public Requirement getRequirements() {
        return requirements;
    }

    public void setRequirements(Requirement requirements) {
        this.requirements = requirements;
    }

    public Category(String categoryName, int photo) {
        this.name = categoryName;
        this.photo = photo;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private class Requirement {
        private List<String> itens;
        private List<String> categories;

        public Requirement(){

        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public List<String> getItens() {
            return itens;
        }

        public void setItens(List<String> itens) {
            this.itens = itens;
        }
    }
}
