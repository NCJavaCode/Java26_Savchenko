
package ua.edu.op.nkpk.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Question extends TestItem implements Cloneable {

    private List<AnswerOption> options;

    public Question(String text) {
        super(text);
        this.options = new ArrayList<>();
    }

    public Question(Question original) {
        this(Objects.requireNonNull(
                original, "Оригінал не може бути null"
        ).getText());

        for (AnswerOption option : original.options) {
            this.options.add(
                    option == null
                            ? null
                            : new AnswerOption(option)
            );
        }
    }

    public String getText() {
        return getName();
    }

    public void addOption(AnswerOption option) {
        options.add(option);
    }

    public List<AnswerOption> getOptions() {
        return Collections.unmodifiableList(options);
    }

    @Override
    public String getInfo() {
        return "Питання: " + getText()
                + "; варіантів: " + options.size();
    }

    @Override
    public Question clone() {
        try {
            Question copy = (Question) super.clone();

            copy.options = new ArrayList<>();

            for (AnswerOption option : options) {
                copy.options.add(
                        option == null
                                ? null
                                : option.clone()
                );
            }

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(
                    "Клонування недоступне", e
            );
        }
    }
}
