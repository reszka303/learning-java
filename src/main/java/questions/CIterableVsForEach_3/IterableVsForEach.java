package questions.CIterableVsForEach_3;

import java.util.Iterator;
import java.util.stream.IntStream;

public class IterableVsForEach {
    public static void main(String[] args) {
        Range range = new Range(5, 15);
        for (Object next : range) {
            System.out.println(next);
        }
    }

    private static class Range implements Iterable{
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public Iterator<Integer> iterator() {
            return IntStream.rangeClosed(start, end).iterator();
        }

        @Override
        public String toString() {
            return start + " : " + end;
        }
    }
}
