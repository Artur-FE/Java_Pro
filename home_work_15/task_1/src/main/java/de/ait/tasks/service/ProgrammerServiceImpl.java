package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.model.Programmer;
import de.ait.tasks.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository programmerRepository;

    @Override
    public Programmer addProgrammer(ProgrammerRequestDto programmerRequestDto) {
        System.out.println(programmerRequestDto);
        Programmer programmer = new Programmer(null, programmerRequestDto.getName());
        System.out.println(programmerRequestDto.getName());
        return programmerRepository.save(programmer);
    }
}
