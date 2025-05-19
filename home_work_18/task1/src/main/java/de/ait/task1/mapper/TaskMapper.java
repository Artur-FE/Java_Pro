package de.ait.task1.mapper;


import de.ait.task1.dto.ProgrammerRequestDto;
import de.ait.task1.dto.ProgrammerResponseDto;
import de.ait.task1.dto.TaskRequestDto;
import de.ait.task1.dto.TaskResponseDto;
import de.ait.task1.model.Programmer;
import de.ait.task1.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    public Task taskRequestDtoToTask(TaskRequestDto taskRequestDto);
    public TaskResponseDto taskToTaskResponseDto(Task task);
    public List<TaskResponseDto> listTaskToListTaskResponseDto(List<Task> task);

}
