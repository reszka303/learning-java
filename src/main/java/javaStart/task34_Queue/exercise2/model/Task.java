package javaStart.task34_Queue.exercise2.model;

public class Task implements Comparable<Task> {
    private Priority priority;
    private String name;
    private String description;

    public Task(Priority priority, String name, String description) {
        this.priority = priority;
        this.name = name;
        this.description = description;
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
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Priority: " + priority.toString().substring(0,1).toUpperCase());
        sb.append(priority.toString().substring(1).toLowerCase());
        sb.append(", Task: " + name);
        sb.append(", Description: " + description);
        return sb.toString();
    }

    public String toCsv() {
        return "";
    }

    @Override
    public int compareTo(Task task) {
        return name.compareTo(task.name);
    }

    public enum Priority {
        HIGH, MODERATE, LOW
    }
}
