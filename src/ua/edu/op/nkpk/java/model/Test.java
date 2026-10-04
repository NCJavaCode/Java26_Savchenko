package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private String title;
    private List<Question> questions;

    public Test(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}