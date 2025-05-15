package de.ait.tasks.service;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Task;

import java.util.List;

public interface TaskService {
   public TaskResponseDto addTask(TaskRequestDto task);
   public List<TaskResponseDto> getAllTasks();
   public TaskResponseDto findById(Long id);
   public TaskResponseDto deleteById(Long id);
}
