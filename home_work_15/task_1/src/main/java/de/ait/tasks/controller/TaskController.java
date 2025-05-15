package de.ait.tasks.controller;

/*
получить список всех задач
получить задачу по id
создать новую задачу
удалить задачу № ...
 */

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.mappers.TaskMapper;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.TaskRepository;
import de.ait.tasks.repository.TaskRepositoryMapImpl;
import de.ait.tasks.service.TaskService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks(){
       try {
           List<TaskResponseDto> allTasks = taskService.getAllTasks();
           return ResponseEntity.ok(allTasks);
       } catch (Exception e) {
           return ResponseEntity.notFound().build();
       }
    }


    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long taskId){
       try {
           return ResponseEntity.ok(taskService.findById(taskId));
       } catch (Exception e) {
           return ResponseEntity.notFound().build();
       }

    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody TaskRequestDto taskRequestDto){
       try {
           TaskResponseDto taskResponseDto1 = taskService.addTask(taskRequestDto);
           ResponseEntity<TaskResponseDto> entity = ResponseEntity.ok(taskResponseDto1);
           return entity;
       } catch (Exception e) {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDto> deleteTaskById(@PathVariable("id") Long id){
        try {
                return ResponseEntity.ok(taskService.deleteById(id));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }




}
