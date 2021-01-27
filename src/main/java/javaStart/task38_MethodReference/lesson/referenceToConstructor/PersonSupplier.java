package javaStart.task38_MethodReference.lesson.referenceToConstructor;

@FunctionalInterface
interface PersonSupplier {
    Person get(String[] fn, String[] ln, int[] a);
}
