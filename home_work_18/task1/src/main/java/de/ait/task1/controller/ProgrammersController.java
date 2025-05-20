package de.ait.task1.controller;


import de.ait.task1.dto.ProgrammerRequestDto;
import de.ait.task1.dto.ProgrammerResponseDto;
import de.ait.task1.mapper.ProgrammerMapper;
import de.ait.task1.model.Programmer;
import de.ait.task1.servise.ProgrammerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")
public class ProgrammersController {
    private final ProgrammerService programmerService;
    private final ProgrammerMapper programmerMapper;

    @GetMapping
    public List<ProgrammerResponseDto> getAllProgrammers(){
        return programmerService.getAllProgrammers();
    }
    @PostMapping
    public ProgrammerResponseDto addProgrammers(@RequestBody ProgrammerRequestDto programmerRequestDto){
        System.out.println(programmerRequestDto.getName() + " programmerRequestDto.getName()");
       // Programmer programmer = programmerMapper.programmerRequestDtoToProgrammer(programmerRequestDto);
       return programmerService.addProgrammers(programmerRequestDto);
    }

    @PutMapping("/{ProgrammerId}/tasks/{TaskId}")
    public ProgrammerResponseDto addTaskByIdToProgrammerById(@PathVariable(name = "ProgrammerId") Long ProgrammerId, @PathVariable(name="TaskId") Long TaskId){
        return programmerService.addTaskProgrammers(ProgrammerId, TaskId);
    }

}
