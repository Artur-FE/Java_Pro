package de.ait.task1.servise;

import de.ait.task1.dto.ProgrammerRequestDto;
import de.ait.task1.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {

    public List<ProgrammerResponseDto> getAllProgrammers();
    public ProgrammerResponseDto getProgrammerById(Long id);
    public ProgrammerResponseDto addProgrammers(ProgrammerRequestDto programmerRequestDto);
    public ProgrammerResponseDto addTaskProgrammers(Long ProgrammersId, Long taskId);

}
