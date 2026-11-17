
package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test extends TestItem {

    private final List<Question> questions;

    public Test(String title) {
        super(title);
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return getName();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public String getInfo() {
        return "Тест: " + getTitle()
                + "; запитань: " + questions.size();
    }
}
