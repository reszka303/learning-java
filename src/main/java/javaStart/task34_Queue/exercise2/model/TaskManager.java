package javaStart.task34_Queue.exercise2.model;

import javaStart.task34_Queue.exercise2.exception.NameTaskAlreadyExistException;
import javaStart.task34_Queue.exercise2.exception.NoIndicatedTaskException;

import java.util.*;

public class TaskManager {
    private Map<String, Queue<Task>> taskMap = new HashMap<>();
    private Queue<Task> taskQueue = new PriorityQueue<>();

    public Map<String, Queue<Task>> getTaskMap() {
        return taskMap;
    }

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    public void addTask(Task task) {
        if (taskMap.containsKey(task.getName())) {
            throw new NameTaskAlreadyExistException("There is a task with the same name" +
                    " in the database: " + task.getName());
        } else {
            taskQueue.add(task);
            taskMap.put(task.getName(), taskQueue);
        }
    }

    public boolean removeTask(Task task) {
        if (taskMap.containsKey(task.getName())) {
            taskQueue.remove(task);
            taskMap.remove(task.getName(), taskQueue);
            return true;
        } else {
            throw new NoIndicatedTaskException("No indicated task");
        }
    }

    public boolean findPriority(Task.Priority priority) {
        for (Task task : taskQueue) {
            if (task.getPriority().equals(priority)) {
                return true;
            }
        }
        return false;
    }
}
