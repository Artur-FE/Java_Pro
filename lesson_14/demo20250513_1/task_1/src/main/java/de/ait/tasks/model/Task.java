package de.ait.tasks.model;

// Task {id, description (описание), priority (приоритет)}

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
public class Task {
    @Setter
    private Long id;
    private String description;
    private Priority priority;


}
