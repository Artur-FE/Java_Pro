package de.ait.tasks.mappers;


import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.dto.TaskResponseDto;
import de.ait.tasks.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task requestDtoToTask(TaskRequestDto task);
    TaskResponseDto taskToResponseDto(Task task);
    List<TaskResponseDto> allTasksToResponseDto(List<Task> tasks);

}
