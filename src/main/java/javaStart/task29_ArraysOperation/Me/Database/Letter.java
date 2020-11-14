package javaStart.task29_ArraysOperation.Me.Database;

import java.io.Serializable;

public class Letter implements Serializable {
    private String text;

    public Letter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "" + text;
    }
}
