package webTechnologies.task1;

public class NumberNotFoundRange extends RuntimeException {
    public NumberNotFoundRange(String message) {
        System.err.println(message);
    }
}
