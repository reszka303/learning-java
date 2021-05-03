package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

public interface Database {
    <T> T[] add(T t);
    <T> T[] remove(int number);
}
