package webTechnologies.task5;

public class TypeWriter {
    public static void main(String[] args) {
        String str = "HELLO WORLD";
        printDelay(str);
    }
    
    private static void printDelay(String text) {
        char[] array = text.toCharArray();
        int capacity = array.length;
        for (int i = 0; i < capacity; i++) {
            System.out.print(array[i]);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
