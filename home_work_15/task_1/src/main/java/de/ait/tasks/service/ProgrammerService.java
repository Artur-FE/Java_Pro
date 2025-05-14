package de.ait.tasks.service;

import de.ait.tasks.dto.ProgrammerRequestDto;
import de.ait.tasks.model.Programmer;

public interface ProgrammerService {

    public Programmer addProgrammer(ProgrammerRequestDto programmerRequestDto);
}
