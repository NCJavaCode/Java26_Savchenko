package ua.edu.op.nkpk.java.model;

/**
 * Клас описує сутність "Варіант відповіді".
 *
 * @author Савченко Ярослав
 * @version 1.0
 */
public class AnswerOption {

    /** Текст відповіді */
    private String text;

    /** Ознака правильності відповіді */
    private boolean isCorrect;

    /**
     * Конструктор варіанта відповіді.
     *
     * @param text текст відповіді
     * @param isCorrect чи є відповідь правильною
     */
    public AnswerOption(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    /**
     * Повертає текст відповіді.
     *
     * @return текст відповіді
     */
    public String getText() {
        return text;
    }

    /**
     * Перевіряє, чи є відповідь правильною.
     *
     * @return true, якщо відповідь правильна
     */
    public boolean isCorrect() {
        return isCorrect;
    }
}