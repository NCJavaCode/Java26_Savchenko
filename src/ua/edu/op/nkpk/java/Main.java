package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;
import ua.edu.op.nkpk.java.service.TestService;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Порівняння об'єктів ===");

        AnswerOption answer1 = new AnswerOption(1, "int", true);
        AnswerOption answer2 = new AnswerOption(1, "int", true);
        AnswerOption answer3 = new AnswerOption(1, "int", true);

        AnswerOption differentId =
                new AnswerOption(2, "int", true);

        AnswerOption differentCorrectness =
                new AnswerOption(1, "int", false);

        AnswerOption differentText =
                new AnswerOption(1, "String", true);

        // == порівнює посилання на об'єкти
        System.out.println(
                "answer1 == answer2: " + (answer1 == answer2)
        ); // false

        // equals() порівнює значення полів
        System.out.println(
                "answer1.equals(answer2): " + answer1.equals(answer2)
        ); // true

        // Рефлексивність
        System.out.println(
                "Рефлексивність: " + answer1.equals(answer1)
        ); // true

        // Симетричність
        System.out.println(
                "Симетричність: "
                        + (answer1.equals(answer2)
                        && answer2.equals(answer1))
        ); // true

        // Транзитивність
        System.out.println(
                "Транзитивність: "
                        + (answer1.equals(answer2)
                        && answer2.equals(answer3)
                        && answer1.equals(answer3))
        ); // true

        // Послідовність за незмінних полів
        boolean firstResult = answer1.equals(answer2);

        System.out.println(
                "Послідовність: "
                        + (firstResult == answer1.equals(answer2)
                        && firstResult == answer1.equals(answer2))
        ); // true

        // Порівняння з null
        System.out.println(
                "Порівняння з null: " + answer1.equals(null)
        ); // false

        // Порівняння з об'єктом іншого класу
        System.out.println(
                "Порівняння з рядком: " + answer1.equals("int")
        ); // false

        // Перевірка впливу кожного поля
        System.out.println(
                "Інший номер: " + answer1.equals(differentId)
        ); // false

        System.out.println(
                "Інша правильність: "
                        + answer1.equals(differentCorrectness)
        ); // false

        System.out.println(
                "Інший текст: " + answer1.equals(differentText)
        ); // false

        // Нерівність за вмістом
        System.out.println(
                "Об'єкти нерівні: " + !answer1.equals(differentId)
        ); // true

        // Рівні об'єкти повинні мати однакові хеш-коди
        System.out.println(
                "Однакові хеш-коди: "
                        + (answer1.hashCode() == answer2.hashCode())
        ); // true

        System.out.println("\n=== Система проведення тестів ===");

        Test javaTest = new Test("Основи Java");

        Question q1 = new Question(
                "Який тип даних використовується для цілих чисел?"
        );

        q1.addOption(new AnswerOption(1, "int", true));
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