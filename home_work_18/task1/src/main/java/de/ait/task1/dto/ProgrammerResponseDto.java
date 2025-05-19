package de.ait.task1.dto;


import de.ait.task1.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProgrammerResponseDto {
    private Long id;
    private String name;
    private Set<Task> tasks;
}
