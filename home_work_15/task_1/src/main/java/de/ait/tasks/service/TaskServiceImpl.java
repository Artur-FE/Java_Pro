package de.ait.tasks.service;


import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.mappers.TaskMapper;
import de.ait.tasks.model.Task;
import de.ait.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;


    @Override
    public TaskResponseDto addTask(TaskRequestDto task) {
        Task save = taskRepository.save(mapper.requestDtoToTask(task));
        return mapper.taskToResponseDto(save);

    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return mapper.allTasksToResponseDto(taskRepository.findAll());
    }

    @Override
    public TaskResponseDto findById(Long id) {
        return mapper.taskToResponseDto(taskRepository.findById(id));
    }

    @Override
    public TaskResponseDto deleteById(Long id) {
       if(taskRepository.delete(id) != null) {
           return mapper.taskToResponseDto(taskRepository.delete(id));
       } else {
           return null;
       }
    }


}
//    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
//       Task task = new Task(null, taskRequestDto.getDescription(), taskRequestDto.getPriority());
//        System.out.println(task.getDescription());
//        taskRepository.save(task);
//        return new TaskResponseDto(task.getId(), task.getDescription(), task.getPriority());
//    }
//}
