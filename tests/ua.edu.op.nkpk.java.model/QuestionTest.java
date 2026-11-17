
package ua.edu.op.nkpk.java.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.edu.op.nkpk.java.model.AnswerOption;
import ua.edu.op.nkpk.java.model.Question;

import static org.junit.Assert.*;

public class QuestionTest {

    private static Question original;

    @BeforeClass
    public static void setUpBeforeClass() {
        original = new Question("Яка мова програмування?");

        original.addOption(
                new AnswerOption(1, "Java", true));

        original.addOption(
                new AnswerOption(2, "HTML", false));

        System.out.println("Початок тестів Question");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Завершення тестів Question");
    }

    @Test
    public void testQuestionTextAndAnswers() {
        assertEquals("Яка мова програмування?",
                original.getText());

        assertEquals(2, original.getOptions().size());

        assertTrue(original.getOptions().get(0).isCorrect());
    }

    @Test
    public void testDeepClone() {
        Question copy = original.clone();

        assertTrue(copy != original);

        assertTrue(copy.getOptions()
                != original.getOptions());

        assertTrue(copy.getOptions().get(0)
                != original.getOptions().get(0));

        assertEquals(original.getOptions().get(0),
                copy.getOptions().get(0));

        assertEquals(original.getText(), copy.getText());
    }

    @Test
    public void testDeepCopyConstructor() {
        Question copy = new Question(original);

        assertTrue(copy != original);

        assertTrue(copy.getOptions()
                != original.getOptions());

        assertTrue(copy.getOptions().get(0)
                != original.getOptions().get(0));

        assertEquals(original.getOptions().get(1),
                copy.getOptions().get(1));
    }

    @Test
    public void testCloneChangeDoesNotModifyOriginal() {
        Question copy = original.clone();

        copy.addOption(
                new AnswerOption(3, "C++", false));

        assertEquals(3, copy.getOptions().size());
        assertEquals(2, original.getOptions().size());
    }

    @Test
    public void testCanAddNullAnswer() {
        Question question = new Question("Перевірка null");

        question.addOption(null);

        assertNull(question.getOptions().get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testCopyConstructorWithNull() {
        new Question((Question) null);
    }
}
