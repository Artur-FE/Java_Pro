package de.ait.task1.servise;

import de.ait.task1.dto.TaskRequestDto;
import de.ait.task1.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {

    public List<TaskResponseDto> getAllTasks();
    public TaskResponseDto getTaskById(Long id);
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto);
}
