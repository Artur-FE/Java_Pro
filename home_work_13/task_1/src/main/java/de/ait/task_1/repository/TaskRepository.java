package de.ait.task_1.repository;

import de.ait.task_1.model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Task> getAllTasks();
    public Task getTaskById(Long id);
    public Task addTask(Task task);
    public boolean deleteTaskById(Long id);
}
