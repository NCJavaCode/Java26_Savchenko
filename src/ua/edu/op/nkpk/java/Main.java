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

        // Копіювання за допомогою clone()
        AnswerOption cloned = original.clone();

        // Копіювання за допомогою конструктора
        AnswerOption copied = new AnswerOption(original);

        System.out.println("\nПеревірка clone():");

        System.out.println(
                "Окремий об'єкт: " + (cloned != original)
        ); // true

        System.out.println(
                "Однаковий клас: "
                        + (cloned.getClass() == original.getClass())
        ); // true

        System.out.println(
                "Однаковий вміст: " + cloned.equals(original)
        ); // true

        System.out.println(
                "Однакові хеш-коди: "
                        + (cloned.hashCode() == original.hashCode())
        ); // true

        System.out.println("\nПеревірка конструктора копіювання:");

        System.out.println(
                "Окремий об'єкт: " + (copied != original)
        ); // true

        System.out.println(
                "Однаковий клас: "
                        + (copied.getClass() == original.getClass())
        ); // true

        System.out.println(
                "Однаковий вміст: " + copied.equals(original)
        ); // true

        System.out.println(
                "Однакові хеш-коди: "
                        + (copied.hashCode() == original.hashCode())
        ); // true

        System.out.println("\n=== Система проведення тестів ===");

        Test javaTest = new Test("Основи Java");

        Question q1 = new Question(
                "Який тип даних використовується для цілих чисел?"
        );

        q1.addOption(original.clone());
        q1.addOption(new AnswerOption(2, "String", false));

        Question q2 = new Question(
                "Який оператор відповідає за умовний вибір?"
        );

        q2.addOption(new AnswerOption(1, "for", false));
        q2.addOption(new AnswerOption(2, "if", true));

        javaTest.addQuestion(q1);
        javaTest.addQuestion(q2);

        TestService testService = new TestService();

        testService.printTestInfo(javaTest);
        testService.runAndEvaluateTest(javaTest);
    }
}