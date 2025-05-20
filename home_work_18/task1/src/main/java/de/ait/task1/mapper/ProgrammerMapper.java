package de.ait.task1.mapper;


import de.ait.task1.dto.ProgrammerRequestDto;
import de.ait.task1.dto.ProgrammerResponseDto;
import de.ait.task1.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    public Programmer programmerRequestDtoToProgrammer(ProgrammerRequestDto programmerRequestDto);
    public ProgrammerResponseDto programmerToProgrammerResponseDto(Programmer programmer);
    public List<ProgrammerResponseDto> listProgrammerToListProgrammerResponseDto(List<Programmer> programmer);

}
