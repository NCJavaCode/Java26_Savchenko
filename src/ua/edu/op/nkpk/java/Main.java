
package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;
import ua.edu.op.nkpk.java.service.TestService;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Клонування об'єктів ===");

        AnswerOption original =
                new AnswerOption(1, "int", true);

        // Клонування
        AnswerOption cloned = original.clone();

        // Конструктор копіювання
        AnswerOption copied = new AnswerOption(original);

        System.out.println("\nПеревірка clone():");

        System.out.println(
                "Окремий об'єкт: " + (cloned != original)
        );

        System.out.println(
                "Однаковий клас: "
                        + (cloned.getClass() == original.getClass())
        );

        System.out.println(
                "Однаковий вміст: " + cloned.equals(original)
        );

        System.out.println(
                "Однакові хеш-коди: "
                        + (cloned.hashCode() == original.hashCode())
        );

        System.out.println("\nПеревірка конструктора копіювання:");

        System.out.println(
                "Окремий об'єкт: " + (copied != original)
        );

        System.out.println(
                "Однаковий клас: "
                        + (copied.getClass() == original.getClass())
        );

        System.out.println(
                "Однаковий вміст: " + copied.equals(original)
        );

        System.out.println(
                "Однакові хеш-коди: "
                        + (copied.hashCode() == original.hashCode())
        );

        // Перевірка equals() та hashCode()
        System.out.println(
                "\n=== Порівняння об'єктів: equals() / hashCode() ==="
        );

        AnswerOption equalOption =
                new AnswerOption(1, "int", true);

        AnswerOption differentId =
                new AnswerOption(2, "int", true);

        AnswerOption differentIsCorrect =
                new AnswerOption(1, "int", false);

        AnswerOption differentText =
                new AnswerOption(1, "Integer", true);

        System.out.println(
                "Однакові значення: "
                        + original.equals(equalOption)
        );

        System.out.println(
                "Різний id (int): "
                        + original.equals(differentId)
        );

        System.out.println(
                "Різний isCorrect (boolean): "
                        + original.equals(differentIsCorrect)
        );

        System.out.println(
                "Різний text (String): "
                        + original.equals(differentText)
        );

        System.out.println(
                "Рефлексивність: "
                        + original.equals(original)
        );

        System.out.println(
                "Симетричність: "
                        + (original.equals(equalOption)
                        == equalOption.equals(original))
        );

        System.out.println(
                "Порівняння з null: "
                        + original.equals(null)
        );

        System.out.println(
                "Рівні об'єкти мають однаковий hashCode: "
                        + (original.hashCode()
                        == equalOption.hashCode())
        );

        // Основна програма
        System.out.println("\n=== Система проведення тестів ===");

        Test javaTest = new Test("Основи Java");

        Question q1 = new Question(
                "Який тип даних використовується для цілих чисел?"
        );

        q1.addOption(original.clone());
        q1.addOption(
                new AnswerOption(2, "String", false)
        );

        Question q2 = new Question(
                "Який оператор відповідає за умовний вибір?"
        );

        q2.addOption(
                new AnswerOption(1, "for", false)
        );

        q2.addOption(
                new AnswerOption(2, "if", true)
        );

        javaTest.addQuestion(q1);
        javaTest.addQuestion(q2);

        TestService testService = new TestService();

        testService.printTestInfo(javaTest);
        testService.runAndEvaluateTest(javaTest);
    }
}
