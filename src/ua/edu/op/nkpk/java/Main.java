
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

        AnswerOption cloned = original.clone();
        AnswerOption copied = new AnswerOption(original);

        System.out.println("\nПеревірка clone():");
        System.out.println("Окремий об'єкт: "
                + (cloned != original));
        System.out.println("Однаковий клас: "
                + (cloned.getClass() == original.getClass()));
        System.out.println("Однаковий вміст: "
                + cloned.equals(original));
        System.out.println("Однакові хеш-коди: "
                + (cloned.hashCode() == original.hashCode()));

        System.out.println("\nПеревірка конструктора копіювання:");
        System.out.println("Окремий об'єкт: "
                + (copied != original));
        System.out.println("Однаковий клас: "
                + (copied.getClass() == original.getClass()));
        System.out.println("Однаковий вміст: "
                + copied.equals(original));
        System.out.println("Однакові хеш-коди: "
                + (copied.hashCode() == original.hashCode()));

        // Перевірка equals() і hashCode()
        System.out.println("\n=== Порівняння об'єктів ===");

        AnswerOption equalOption =
                new AnswerOption(1, "int", true);

        AnswerOption differentId =
                new AnswerOption(2, "int", true);

        AnswerOption differentIsCorrect =
                new AnswerOption(1, "int", false);

        AnswerOption differentText =
                new AnswerOption(1, "Integer", true);

        System.out.println("Однакові значення: "
                + original.equals(equalOption));

        System.out.println("Різний id: "
                + original.equals(differentId));

        System.out.println("Різний isCorrect: "
                + original.equals(differentIsCorrect));

        System.out.println("Різний text: "
                + original.equals(differentText));

        System.out.println("Рефлексивність: "
                + original.equals(original));

        System.out.println("Симетричність: "
                + (original.equals(equalOption)
                == equalOption.equals(original)));

        System.out.println("Порівняння з null: "
                + original.equals(null));

        System.out.println("Однакові hashCode: "
                + (original.hashCode()
                == equalOption.hashCode()));

        // Глибоке клонування Question
        System.out.println("\n=== Глибоке клонування Question ===");

        Question questionOriginal =
                new Question("Мова програмування?");

        questionOriginal.addOption(
                new AnswerOption(1, "Java", true));

        questionOriginal.addOption(
                new AnswerOption(2, "Python", false));

        Question questionClone = questionOriginal.clone();
        Question questionCopy = new Question(questionOriginal);

        System.out.println("clone(): новий об'єкт: "
                + (questionClone != questionOriginal));

        System.out.println("clone(): новий список: "
                + (questionClone.getOptions()
                != questionOriginal.getOptions()));

        System.out.println("clone(): нові елементи списку: "
                + (questionClone.getOptions().get(0)
                != questionOriginal.getOptions().get(0)));

        System.out.println("clone(): однакові значення: "
                + questionClone.getOptions().get(0)
                .equals(questionOriginal.getOptions().get(0)));

        System.out.println("Конструктор: новий об'єкт: "
                + (questionCopy != questionOriginal));

        System.out.println("Конструктор: новий список: "
                + (questionCopy.getOptions()
                != questionOriginal.getOptions()));

        System.out.println("Конструктор: нові елементи списку: "
                + (questionCopy.getOptions().get(0)
                != questionOriginal.getOptions().get(0)));

        questionClone.addOption(
                new AnswerOption(3, "C++", false));

        System.out.println("Зміна клона не змінила оригінал: "
                + (questionOriginal.getOptions().size() == 2));

        // ПРАКТИКУМ №8
        System.out.println("\n=== Обробка виключних ситуацій ===");

        // Завдання 1: ArrayIndexOutOfBoundsException
        int[] scores = {5, 4, 3, 5};

        showArrayElement(scores, 2);
        showArrayElement(scores, 9);

        // Завдання 2: NullPointerException
        Question existingQuestion =
                new Question("Що таке Java?");

        showQuestionText(existingQuestion);
        showQuestionText(null);

        // Основна система тестування
        System.out.println("\n=== Система проведення тестів ===");

        Test javaTest = new Test("Основи Java");

        Question q1 = new Question(
                "Який тип даних використовується для цілих чисел?");

        q1.addOption(original.clone());
        q1.addOption(new AnswerOption(2, "String", false));

        Question q2 = new Question(
                "Який оператор відповідає за умовний вибір?");

        q2.addOption(new AnswerOption(1, "for", false));
        q2.addOption(new AnswerOption(2, "if", true));

        javaTest.addQuestion(q1);
        javaTest.addQuestion(q2);

        TestService testService = new TestService();

        testService.printTestInfo(javaTest);
        testService.runAndEvaluateTest(javaTest);
    }

    // Обробка виходу за межі масиву
    private static void showArrayElement(int[] values, int index) {
        try {
            System.out.println("Елемент масиву [" + index
                    + "]: " + values[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(
                    "Помилка ArrayIndexOutOfBoundsException: "
                            + "допустимі індекси від 0 до "
                            + (values.length - 1)
                            + ", звернення до індексу " + index + "."
            );
        }
    }

    // Обробка звернення до null
    private static void showQuestionText(Question question) {
        try {
            System.out.println(
                    "Текст питання: " + question.getText()
            );

        } catch (NullPointerException e) {
            System.err.println(
                    "Помилка NullPointerException: "
                            + "об'єкт класу Question відсутній (null)."
            );
        }
    }
}
