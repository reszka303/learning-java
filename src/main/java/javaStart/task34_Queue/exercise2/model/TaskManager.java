package javaStart.task34_Queue.exercise2.model;

import java.io.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.TreeSet;

public class TaskManager {
    private static final String COMMA_DELIMITER = ";";

    public static Map<Task.Priority, TreeSet<Task>> readFile(String fileName) throws IOException {
        Map<Task.Priority, TreeSet<Task>> priorityTaskEnumMap = new EnumMap<Task.Priority, TreeSet<Task>>(Task.Priority.class);
        try (var bR = new BufferedReader(new FileReader(fileName))
        ){
            bR.readLine();
            String line;

            while ((line = bR.readLine()) != null) {
                Task task = createTaskFromStringArray(line);
                insertTaskToMap(priorityTaskEnumMap, task.getPriority(), task);
            }
        }
        return priorityTaskEnumMap;
    }

    private static Task createTaskFromStringArray(String line) {
        String[] data = line.split(COMMA_DELIMITER);
        Task.Priority priority = Task.Priority.valueOf(data[0]);
        String name = data[1];
        String description = data[2];

        return new Task(priority, name, description);
    }

    private static void insertTaskToMap(Map<Task.Priority, TreeSet<Task>> priorityTaskEnumMap, Task.Priority priority, Task task) {
        if (priorityTaskEnumMap.containsKey(priority)) {
            priorityTaskEnumMap.get(priority).add(task);
        } else {
            TreeSet<Task> taskTreeSet = new TreeSet<>();
            taskTreeSet.add(task);
            priorityTaskEnumMap.put(priority, taskTreeSet);
        }
    }

//    private static Map<Task.Priority, TreeSet<Task>> writeFile(String fileName) throws IOException {
//        Map<Task.Priority, TreeSet<Task>> priorityTaskEnumMap = new EnumMap<Task.Priority, TreeSet<Task>>(Task.Priority.class);
//        try (var bw = new BufferedWriter(new FileWriter(fileName))
//        ){
//            bw.newLine();
//            String line;
//
//        }
//    }
}
