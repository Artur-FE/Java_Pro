package de.ait.tasks.service;

import de.ait.tasks.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
}
