package de.ait.task1.controller;


import de.ait.task1.dto.TaskRequestDto;
import de.ait.task1.dto.TaskResponseDto;
import de.ait.task1.mapper.TaskMapper;
import de.ait.task1.model.Task;
import de.ait.task1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskResponseDto> getAllTasks(){
        return taskMapper.listTaskToListTaskResponseDto(taskRepository.findAll());
    }

    @PostMapping
    public TaskResponseDto addTask(@RequestBody TaskRequestDto taskRequestDto){
        Task task = taskMapper.taskRequestDtoToTask(taskRequestDto);
        System.out.println(task.getDescription());
        return taskMapper.taskToTaskResponseDto(taskRepository.save(task));
    }
}
