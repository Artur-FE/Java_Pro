package de.ait.tasks.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.tasks.model.Task;
import de.ait.tasks.repository.TaskRepository;
import de.ait.tasks.repository.TaskRepositoryMapImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {
    private final TaskRepository repository;

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return repository.findAll();
    }


    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId){
       return repository.findById(taskId);
    }

    @PostMapping("/tasks")
    public Task createNewTask(@RequestBody Task task){
        System.out.println(task);
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public  Task deleteTaskById(@PathVariable("id") Long id){
        return repository.delete(id);
    }




}
