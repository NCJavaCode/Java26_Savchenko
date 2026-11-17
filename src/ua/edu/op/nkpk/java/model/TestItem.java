
package ua.edu.op.nkpk.java.model;

import java.util.Objects;

public abstract class TestItem {

    private final String name;

    protected TestItem(String name) {
        this.name = Objects.requireNonNull(
                name, "Назва не може бути null"
        );
    }

    public final String getName() {
        return name;
    }

    public abstract String getInfo();
}
