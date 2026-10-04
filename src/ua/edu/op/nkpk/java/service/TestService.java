package ua.edu.op.nkpk.java.service;

import ua.edu.op.nkpk.java.model.Test;

public class TestService {
    public void printTestInfo(Test test) {
        System.out.println("Тест: " + test.getTitle());
        System.out.println("Кількість питань: " + test.getQuestions().size());
    }

    public int evaluateTest(Test test) {
        return 0;
    }
}