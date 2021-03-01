package javaStart.task34_Queue.exercise2.io.file;

import javaStart.task34_Queue.exercise2.exception.DataReadException;
import javaStart.task34_Queue.exercise2.exception.DataWriteException;
import javaStart.task34_Queue.exercise2.model.Task;
import javaStart.task34_Queue.exercise2.model.TaskManager;

import java.io.*;

import java.util.*;

public class CsvFileManager {
    private static String FILE_NAME = "D:\\INNE\\Programowanie\\Projects\\learning\\tasks.txt";
    private static final String COMMA_DELIMITER = ",";
    private static final String HEADER = "task,description,priority";

    public void writeData(TaskManager taskManager) {
        writeTasks(taskManager);
    }

    public TaskManager readData() {
        TaskManager taskManager = new TaskManager();
        readTasks(taskManager);
        return taskManager;
    }

    private void writeTasks(TaskManager taskManager) {
        Queue<Task> taskQueue = taskManager.getTaskQueue();
        writeFileToCsv(taskQueue, FILE_NAME);
    }

    public Map<String, Queue<Task>> readTasks(TaskManager taskManager) {
        Map<String, Queue<Task>> tasksMap = new HashMap<>();
        try (var bR = new BufferedReader(new FileReader(FILE_NAME))
        ){
            bR.readLine();
            String line;
            while ((line = bR.readLine()) != null) {
                Task task = createTaskFromStringArray(line);
                taskManager.addTask(task);
            }
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataReadException("Error a read data " +  FILE_NAME);
        }
        return tasksMap;
    }

    private static Task createTaskFromStringArray(String line) {
        String[] data = line.split(COMMA_DELIMITER);
        String name = data[0];
        String description = data[1];
        Task.Priority priority = Task.Priority.valueOf(data[2]);
        return new Task(name, description, priority);
    }

    public void writeFileToCsv(Queue<Task> taskQueue, String fileName) {
        try (var bw = new BufferedWriter(new FileWriter(fileName))
        ){
            bw.write(HEADER);
            bw.newLine();
            for (Task task : taskQueue) {
                bw.write(task.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new DataWriteException("Error a write data into a file " + fileName);
        }
    }
}
