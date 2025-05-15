package de.ait.tasks.dto;

import de.ait.tasks.model.Priority;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@Setter
@Component

public class TaskResponseDto {
    private Long id;
    private String description;
    private Priority priority;
}

