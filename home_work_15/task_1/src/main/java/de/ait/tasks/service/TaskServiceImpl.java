package de.ait.tasks.service;


import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task addTask(TaskRequestDto taskRequestDto) {
       Task task = new Task(null, taskRequestDto.getDescription(), taskRequestDto.getPriority());
        System.out.println(task.getDescription());
        return taskRepository.save(task);
    }
}
