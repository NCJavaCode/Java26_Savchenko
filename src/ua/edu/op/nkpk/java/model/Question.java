package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас описує сутність "Тестове питання".
 *
 * @author Савченко Ярослав
 * @version 1.0
 */
public class Question {

    /** Текст питання */
    private String text;

    /** Варіанти відповідей */
    private List<AnswerOption> options;

    /**
     * Конструктор створення питання.
     *
     * @param text текст питання
     */
    public Question(String text) {
        this.text = text;
        this.options = new ArrayList<>();
    }

    /**
     * Повертає текст питання.
     *
     * @return текст питання
     */
    public String getText() {
        return text;
    }

    /**
     * Додає варіант відповіді.
     *
     * @param option об'єкт варіанта відповіді
     */
    public void addOption(AnswerOption option) {
        this.options.add(option);
    }

    /**
     * Повертає варіанти відповідей.
     *
     * @return список варіантів
     */
    public List<AnswerOption> getOptions() {
        return options;
    }
}