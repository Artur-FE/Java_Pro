package de.ait.task_1.model;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class Programmer {

    @Setter
    private Long id;
    private String name;
    private List<Task> tasks;

    public Programmer(Long id) {
        this.id = id;
    }
}

