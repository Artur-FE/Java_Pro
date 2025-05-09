package de.ait.task_1.controller;

import de.ait.task_1.model.Task;
import de.ait.task_1.repository.TaskDB;
import de.ait.task_1.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    TaskRepository taskRepository = new TaskDB();

    @GetMapping(value="/tasks")
    public List<Task> getTasks() {
        return taskRepository.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") Long id) {
        return taskRepository.getTaskById(id);
    }

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        taskRepository.addTask(task);
        return task;
    }

    @DeleteMapping("deleteTask/{id}")
    public boolean deleteTask(@PathVariable(value = "id") Long id){
       return taskRepository.deleteTaskById(id);
    }
}
