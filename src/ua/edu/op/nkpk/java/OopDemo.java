
package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;
import ua.edu.op.nkpk.java.model.TestItem;

public class OopDemo {

    public static void main(String[] args) {

        Question question =
                new Question("Що таке Java?");

        question.addOption(
                new AnswerOption(
                        1, "Мова програмування", true
                )
        );

        Test test = new Test("Основи Java");
        test.addQuestion(question);

        System.out.println(
                "=== Абстрагування та спадкування ==="
        );

        TestItem[] items = {question, test};

        for (TestItem item : items) {
            System.out.println(item.getInfo());
        }

        System.out.println("\n=== Інкапсуляція ===");

        try {
            question.getOptions().clear();

        } catch (UnsupportedOperationException e) {
            System.out.println(
                    "Інкапсуляція працює: "
                            + "пряме видалення заборонене."
            );
        }

        System.out.println(
                "Кількість відповідей: "
                        + question.getOptions().size()
        );
    }
}
