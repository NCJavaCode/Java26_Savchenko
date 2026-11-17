
package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;
import ua.edu.op.nkpk.java.model.TestItem;

public class OopDemo {

    // Статичний поліморфізм: перевантаження методів
    public static void showInfo(Question question) {
        System.out.println("Питання: " + question.getText());
    }

    public static void showInfo(Test test) {
        System.out.println("Тест: " + test.getTitle());
    }

    public static void main(String[] args) {

        Question question = new Question("Що таке Java?");

        question.addOption(
                new AnswerOption(1, "Мова програмування", true)
        );

        question.addOption(
                new AnswerOption(2, "Операційна система", false)
        );

        Test test = new Test("Основи Java");
        test.addQuestion(question);

        // Завдання 1. Статичний поліморфізм
        System.out.println("=== Статичний поліморфізм ===");

        showInfo(question);
        showInfo(test);

        // Завдання 2. Динамічний поліморфізм
        System.out.println("\n=== Динамічний поліморфізм ===");

        TestItem[] items = {question, test};

        for (TestItem item : items) {
            System.out.println(item.getInfo());
        }

        // Перевірка інкапсуляції
        System.out.println("\n=== Інкапсуляція ===");

        try {
            question.getOptions().clear();

        } catch (UnsupportedOperationException e) {
            System.out.println(
                    "Пряма зміна списку відповідей заборонена."
            );
        }

        System.out.println(
                "Кількість відповідей: "
                        + question.getOptions().size()
        );
    }
}
