package de.ait.task1.servise;

import de.ait.task1.dto.ProgrammerRequestDto;
import de.ait.task1.dto.ProgrammerResponseDto;
import de.ait.task1.mapper.ProgrammerMapper;
import de.ait.task1.model.Programmer;
import de.ait.task1.model.Task;
import de.ait.task1.repository.ProgrammerRepository;
import de.ait.task1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository programmerRepository;
    private final ProgrammerMapper programmerMapper;
    private final TaskRepository taskRepository;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
        return programmerMapper.listProgrammerToListProgrammerResponseDto(programmerRepository.findAll());
    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long id) {
        return programmerMapper.programmerToProgrammerResponseDto(programmerRepository.findById(id).get());
    }

    @Override
    public ProgrammerResponseDto addProgrammers(ProgrammerRequestDto programmerRequestDto) {
        System.out.println(programmerRequestDto.getName());
        Programmer programmer = programmerMapper.programmerRequestDtoToProgrammer(programmerRequestDto);

        programmerRepository.save(programmer);
        System.out.println(programmer.getName());
        return programmerMapper.programmerToProgrammerResponseDto(programmer);
    }

    @Override
    public ProgrammerResponseDto addTaskProgrammers(Long ProgrammersId, Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        Programmer programmer = programmerRepository.findById(ProgrammersId).get();
        task.setProgrammer(programmer);
        taskRepository.save(task);
        programmer.getTasks().add(task);
        programmerRepository.save(programmer);
        return programmerMapper.programmerToProgrammerResponseDto(programmer);
    }
}
