package ua.edu.op.nkpk.java.model;

import java.util.Objects;

/**
 * Клас описує сутність "Варіант відповіді".
 *
 * @author Савченко Ярослав
 * @version 1.1
 */
public class AnswerOption {

    /** Номер варіанта відповіді */
    private int id;

    /** Текст відповіді */
    private String text;

    /** Ознака правильності відповіді */
    private boolean isCorrect;

    /**
     * Конструктор варіанта відповіді.
     *
     * @param id номер варіанта відповіді
     * @param text текст відповіді
     * @param isCorrect чи є відповідь правильною
     */
    public AnswerOption(int id, String text, boolean isCorrect) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    /**
     * Конструктор для сумісності з попереднім кодом.
     *
     * @param text текст відповіді
     * @param isCorrect чи є відповідь правильною
     */
    public AnswerOption(String text, boolean isCorrect) {
        this(0, text, isCorrect);
    }

    /**
     * @return номер варіанта відповіді
     */
    public int getId() {
        return id;
    }

    /**
     * @return текст відповіді
     */
    public String getText() {
        return text;
    }

    /**
     * @return true, якщо відповідь правильна
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Порівнює об'єкти за номером, текстом і правильністю.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо значення всіх полів однакові
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
     * Обчислює хеш-код за полями, використаними в equals().
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, text, isCorrect);
    }
}