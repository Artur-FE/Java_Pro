package de.ait.task_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class Programmer {
    private Long id;
    private String name;
    private List<Task> tasks;

    public Programmer(Long id) {
        this.id = id;
    }
}

