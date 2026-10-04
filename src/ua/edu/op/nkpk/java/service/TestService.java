package ua.edu.op.nkpk.java.service;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;

import java.util.List;
import java.util.Scanner;

public class TestService {

    public void printTestInfo(Test test) {
        // 1. Логічна операція (&&) та операція порівняння (!=)
        // 2. Умовна конструкція if/else
        if (test != null && test.getQuestions() != null) {
            System.out.println("Тест: " + test.getTitle());
            System.out.println("Кількість питань: " + test.getQuestions().size());
        } else {
            System.out.println("Тест відсутній або порожній.");
        }
    }

    public int runAndEvaluateTest(Test test) {
        if (test == null || test.getQuestions().isEmpty()) {
            return 0;
        }

        Scanner scanner = new Scanner(System.in);
        List<Question> questions = test.getQuestions();
        int correctAnswersCount = 0;
        int questionIndex = 0;

        // 3. Цикл while
        while (questionIndex < questions.size()) {
            Question q = questions.get(questionIndex);
            System.out.println("\nПитання №" + (questionIndex + 1) + ": " + q.getText());

            List<AnswerOption> options = q.getOptions();

            // 4. Цикл for
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getText());
            }

            System.out.print("Введіть номер вашої відповіді: ");
            int userChoice = scanner.nextInt();

            if (userChoice < 1 || userChoice > options.size()) {
                System.out.println("Некоректний вибір! Варіант не зараховано.");
            } else {
                AnswerOption selectedOption = options.get(userChoice - 1);

                if (selectedOption.isCorrect()) {
                    System.out.println("Вірно!");
                    // 5. Унарний арифметичний оператор (++)
                    correctAnswersCount++;
                } else {
                    System.out.println("Невірно!");
                }
            }

            // Унарний оператор (++)
            questionIndex++;
        }

        // 6. Бінарний арифметичний оператор (*)
        int scorePercentage = (correctAnswersCount * 100) / questions.size();

        int gradeCategory;
        if (scorePercentage >= 90) {
            gradeCategory = 5;
        } else if (scorePercentage >= 75) {
            gradeCategory = 4;
        } else if (scorePercentage >= 60) {
            gradeCategory = 3;
        } else {
            gradeCategory = 2;
        }

        System.out.println("\n=== РЕЗУЛЬТАТ ТЕСТУ ===");
        // 7. Конструкція вибору switch
        switch (gradeCategory) {
            case 5:
                System.out.println("Оцінка: Відмінно (" + scorePercentage + "%)");
                break;
            case 4:
                System.out.println("Оцінка: Добре (" + scorePercentage + "%)");
                break;
            case 3:
                System.out.println("Оцінка: Задовільно (" + scorePercentage + "%)");
                break;
            default:
                System.out.println("Оцінка: Незадовільно (" + scorePercentage + "%)");
                break;
        }

        return scorePercentage;
    }
}