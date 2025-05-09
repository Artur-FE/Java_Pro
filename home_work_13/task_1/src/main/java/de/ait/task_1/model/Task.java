package de.ait.task_1.model;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class Task {
    private Long id;
    private String description;
    private Priority priority;
    @Setter
    private boolean isTaken;
    @Setter
    private Long ProgrammerId;

    @Setter
    private boolean statusIsOpen;
    private LocalDateTime createDateTime;
    private LocalDateTime closedDateTime;



    public Task(Long id) {
        this.id = id;
    }
}
