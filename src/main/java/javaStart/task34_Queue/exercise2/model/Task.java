package javaStart.task34_Queue.exercise2.model;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private String name;
    private String description;
    private Priority priority;

    public Task(String name, String description, Priority priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public Task(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Task: " + name);
        sb.append(", Description: " + description);
        sb.append(", Priority: " + priority.toString().substring(0,1).toUpperCase());
        sb.append(priority.toString().substring(1).toLowerCase());
        return sb.toString();
    }

    public String toCsv() {
        return name + "," + description + "," + priority;
    }

    @Override
    public int compareTo(Task task) {
        return name.compareTo(task.name);
    }

    public enum Priority {
        HIGH, MODERATE, LOW;
    }
}
