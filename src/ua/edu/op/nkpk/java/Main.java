package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;
import ua.edu.op.nkpk.java.service.TestService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Система створення та проходження тестів ===");

        Test javaTest = new Test("Основи мови Java");

        Question q1 = new Question("Який тип даних використовується для цілих чисел?");
        q1.addOption(new AnswerOption("int", true));
        q1.addOption(new AnswerOption("String", false));

        javaTest.addQuestion(q1);

        TestService testService = new TestService();
        testService.printTestInfo(javaTest);
    }
}