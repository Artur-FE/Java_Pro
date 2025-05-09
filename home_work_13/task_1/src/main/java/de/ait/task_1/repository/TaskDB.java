package de.ait.task_1.repository;

import de.ait.task_1.model.Priority;
import de.ait.task_1.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskDB implements TaskRepository{

    static Map<Long, Task> tasks = new HashMap<>();
    static {
        tasks.put(1L, new Task(1L, "Task1", Priority.LOW, false, null, true, LocalDateTime.now(), null));
        tasks.put(2L, new Task(2L, "Task2", Priority.HIGH, false, null, true, LocalDateTime.now(), null));
        tasks.put(3L, new Task(3L, "Task3", Priority.HIGH, false, null, true, LocalDateTime.now(), null));
        tasks.put(4L, new Task(4L, "Task4", Priority.MEDIUM, false, null, true, LocalDateTime.now(), null));
        tasks.put(5L, new Task(5L, "Task5", Priority.HIGH, false, null, true, LocalDateTime.now(), null));
        tasks.put(6L, new Task(6L, "Task6", Priority.LOW, false, null, true, LocalDateTime.now(), null));
        tasks.put(7L, new Task(7L, "Task7", Priority.MEDIUM, false, null, true, LocalDateTime.now(), null));
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks.values().stream().toList();
    }

    @Override
    public Task getTaskById(Long id) {
        return tasks.get(id);
    }

    @Override
    public Task addTask(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public boolean deleteTaskById(Long id) {
        return tasks.remove(id) != null;
    }
}
