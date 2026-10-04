package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас описує сутність "Тест".
 *
 * @author Савченко Ярослав
 * @version 1.0
 */
public class Test {

    /** Назва тесту */
    private String title;

    /** Список питань у тесті */
    private List<Question> questions;

    /**
     * Конструктор для створення тесту.
     *
     * @param title назва тесту
     */
    public Test(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    /**
     * Повертає назву тесту.
     *
     * @return назва тесту
     */
    public String getTitle() {
        return title;
    }

    /**
     * Додає питання до тесту.
     *
     * @param question об'єкт питання
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * Повертає список питань.
     *
     * @return список об'єктів Question
     */
    public List<Question> getQuestions() {
        return questions;
    }
}