package de.ait.task1.servise;

import de.ait.task1.dto.TaskRequestDto;
import de.ait.task1.dto.TaskResponseDto;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    @Override
    public List<TaskResponseDto> getAllTasks() {
        return List.of();
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return null;
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        return null;
    }
}
