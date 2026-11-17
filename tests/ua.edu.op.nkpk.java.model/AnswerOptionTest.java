
package ua.edu.op.nkpk.java.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.edu.op.nkpk.java.model.AnswerOption;

import static org.junit.Assert.*;

public class AnswerOptionTest {

    private static AnswerOption original;

    @BeforeClass
    public static void setUpBeforeClass() {
        original = new AnswerOption(1, "Java", true);
        System.out.println("Початок тестів AnswerOption");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Завершення тестів AnswerOption");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(1, original.getId());
        assertEquals("Java", original.getText());
        assertTrue(original.isCorrect());
    }

    @Test
    public void testEqualsAndHashCode() {
        AnswerOption second =
                new AnswerOption(1, "Java", true);

        assertTrue(original.equals(second));
        assertEquals(original.hashCode(), second.hashCode());
    }

    @Test
    public void testDifferentValuesAreNotEqual() {
        assertTrue(!original.equals(
                new AnswerOption(2, "Java", true)));

        assertTrue(!original.equals(
                new AnswerOption(1, "Java", false)));

        assertTrue(!original.equals(
                new AnswerOption(1, "Python", true)));
    }

    @Test
    public void testCloneCreatesIndependentObject() {
        AnswerOption copy = original.clone();

        assertTrue(copy != original);
        assertEquals(original, copy);
    }

    @Test
    public void testCopyConstructor() {
        AnswerOption copy = new AnswerOption(original);

        assertTrue(copy != original);
        assertEquals(original, copy);
    }

    @Test
    public void testNullText() {
        AnswerOption option =
                new AnswerOption(5, null, false);

        assertNull(option.getText());
    }

    @Test(expected = NullPointerException.class)
    public void testCopyConstructorWithNull() {
        new AnswerOption((AnswerOption) null);
    }
}
