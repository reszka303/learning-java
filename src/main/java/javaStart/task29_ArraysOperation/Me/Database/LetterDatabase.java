package javaStart.task29_ArraysOperation.Me.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LetterDatabase implements Serializable {
    private List<Letter> letters = new ArrayList<>();

    public List<Letter> getLetters() {
        return letters;
    }

    void add(Letter letter) {
        letters.add(letter);
    }
}
