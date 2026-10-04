package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private List<AnswerOption> options;

    public Question(String text) {
        this.text = text;
        this.options = new ArrayList<>();
    }

    public void addOption(AnswerOption option) {
        options.add(option);
    }

    public String getText() {
        return text;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }
}