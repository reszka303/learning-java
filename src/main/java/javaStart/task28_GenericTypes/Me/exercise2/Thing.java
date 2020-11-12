package javaStart.task28_GenericTypes.Me.exercise2;

public class Thing<F1, F2, F3, F4> {
    private F1 feature1;
    private F2 feature2;
    private F3 feature3;
    private F4 feature4;

    public Thing(F1 feature1, F2 feature2, F3 feature3, F4 feature4) {
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.feature4 = feature4;
    }

    public F1 getFeature1() {
        return feature1;
    }

    public F2 getFeature2() {
        return feature2;
    }

    public F3 getFeature3() {
        return feature3;
    }

    public F4 getFeature4() {
        return feature4;
    }

    @Override
    public String toString() {
        return "" + feature1 + " " + feature2 + " "  + feature3 + " "  + feature4;
    }
}
