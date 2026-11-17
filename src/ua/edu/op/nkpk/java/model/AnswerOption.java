
package ua.edu.op.nkpk.java.model;

import java.util.Objects;

public class AnswerOption implements Cloneable {

    private int id;
    private String text;
    private boolean isCorrect;

    public AnswerOption(int id, String text, boolean isCorrect) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public AnswerOption(String text, boolean isCorrect) {
        this(0, text, isCorrect);
    }

    public AnswerOption(AnswerOption original) {
        Objects.requireNonNull(original, "Оригінал не може бути null");

        this.id = original.id;
        this.text = original.text;
        this.isCorrect = original.isCorrect;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public AnswerOption clone() {
        try {
            return (AnswerOption) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(
                    "Клас повинен підтримувати клонування", e
            );
        }
    }

    // Порівняння об'єктів за двома примітивними
    // полями id, isCorrect та полем text
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        AnswerOption other = (AnswerOption) obj;

        return id == other.id
                && isCorrect == other.isCorrect
                && Objects.equals(text, other.text);
    }

    // Перевизначення методу hashCode()
    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + Boolean.hashCode(isCorrect);
        result = 31 * result + Objects.hashCode(text);
        return result;
    }
}
