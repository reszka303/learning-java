package javaStart.task32_Set.Me.exercise1;

import java.util.Objects;

public class Names {
    private String name;

    public Names(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names = (Names) o;
        return Objects.equals(name, names.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
