package de.ait.task1.servise;

import de.ait.task1.dto.TaskRequestDto;
import de.ait.task1.dto.TaskResponseDto;
import de.ait.task1.mapper.TaskMapper;
import de.ait.task1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskMapper.listTaskToListTaskResponseDto(taskRepository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return taskMapper.taskToTaskResponseDto(taskRepository.findById(id).get());
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        return taskMapper.taskToTaskResponseDto(taskRepository.save(taskMapper.taskRequestDtoToTask(taskRequestDto)));

    }
}
