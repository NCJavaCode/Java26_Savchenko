package ua.edu.op.nkpk.java.model;

import java.util.Objects;

/**
 * Клас описує сутність "Варіант відповіді".
 *
 * @author Савченко Ярослав
 * @version 1.2
 */
public class AnswerOption implements Cloneable {

    /** Номер варіанта відповіді */
    private int id;

    /** Текст відповіді */
    private String text;

    /** Ознака правильності відповіді */
    private boolean isCorrect;

    /**
     * Основний конструктор.
     *
     * @param id номер відповіді
     * @param text текст відповіді
     * @param isCorrect ознака правильності
     */
    public AnswerOption(int id, String text, boolean isCorrect) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    /**
     * Конструктор без зазначення номера.
     *
     * @param text текст відповіді
     * @param isCorrect ознака правильності
     */
    public AnswerOption(String text, boolean isCorrect) {
        this(0, text, isCorrect);
    }

    /**
     * Конструктор копіювання.
     *
     * @param original об'єкт, який потрібно скопіювати
     */
    public AnswerOption(AnswerOption original) {
        Objects.requireNonNull(original, "Оригінал не може бути null");

        this.id = original.id;
        this.text = original.text;
        this.isCorrect = original.isCorrect;
    }

    /** @return номер відповіді */
    public int getId() {
        return id;
    }

    /** @return текст відповіді */
    public String getText() {
        return text;
    }

    /** @return ознака правильності */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Створює копію об'єкта.
     * Примітивні поля копіюються за значенням.
     * String є незмінним, тому його можна безпечно
     * використовувати спільно з оригіналом.
     *
     * @return копія варіанта відповіді
     */
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

    /**
     * Порівнює об'єкти за значеннями полів.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо всі поля однакові
     */
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

    /**
     * @return хеш-код за полями id, text та isCorrect
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, text, isCorrect);
    }
}