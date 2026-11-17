
package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question implements Cloneable {

    private String text;
    private List<AnswerOption> options;

    public Question(String text) {
        this.text = text;
        this.options = new ArrayList<>();
    }

    // Конструктор глибокого копіювання
    public Question(Question original) {
        Objects.requireNonNull(original,
                "Оригінал не може бути null");

        this.text = original.text;
        this.options = new ArrayList<>();

        for (AnswerOption option : original.options) {
            this.options.add(
                    option == null ? null : new AnswerOption(option)
            );
        }
    }

    public String getText() {
        return text;
    }

    public void addOption(AnswerOption option) {
        options.add(option);
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    // Глибоке клонування об'єкта
    @Override
    public Question clone() {
        try {
            Question copy = (Question) super.clone();

            copy.options = new ArrayList<>();

            for (AnswerOption option : options) {
                copy.options.add(
                        option == null ? null : option.clone()
                );
            }

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(
                    "Клонування недоступне", e
            );
        }
    }
}
