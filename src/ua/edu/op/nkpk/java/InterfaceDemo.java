
package ua.edu.op.nkpk.java;

import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Nameble;
import ua.edu.op.nkpk.java.model.Printable;
import ua.edu.op.nkpk.java.model.Question;
import ua.edu.op.nkpk.java.model.Test;

public class InterfaceDemo {

    public static void main(String[] args) {

        Question question = new Question("Що таке Java?");

        question.addOption(
                new AnswerOption(
                        1, "Мова програмування", true
                )
        );

        Test test = new Test("Основи Java");
        test.addQuestion(question);

        // Використання інтерфейсу Nameble
        Nameble[] namedObjects = {question, test};

        System.out.println("=== Інтерфейс Nameble ===");

        for (Nameble item : namedObjects) {
            System.out.println(
                    "Назва класу: " + item.getClassName()
            );
        }

        // Використання інтерфейсу Printable
        Printable[] printableObjects = {question, test};

        System.out.println("\n=== Інтерфейс Printable ===");

        for (Printable item : printableObjects) {
            item.printInfo();
        }
    }
}
