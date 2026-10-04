package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;
import ua.edu.op.nkpk.java.service.TestService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Система проведення тестів ===");

        Test javaTest = new Test("Основи Java");

        Question q1 = new Question("Який тип даних використовується для цілих чисел?");
        q1.addOption(new AnswerOption("int", true));
        q1.addOption(new AnswerOption("String", false));

        Question q2 = new Question("Який оператор відповідає за умовний вибір?");
        q2.addOption(new AnswerOption("for", false));
        q2.addOption(new AnswerOption("if", true));

        javaTest.addQuestion(q1);
        javaTest.addQuestion(q2);

        TestService testService = new TestService();
        testService.printTestInfo(javaTest);
        testService.runAndEvaluateTest(javaTest);
    }
}