package de.ait.task1.dto;


import de.ait.task1.model.Programmer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TaskResponseDto {
    private Long id;
    private String description;
    private Programmer programmer;
}
