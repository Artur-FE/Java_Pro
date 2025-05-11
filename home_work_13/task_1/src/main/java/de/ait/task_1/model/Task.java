package de.ait.task_1.model;


import de.ait.task_1.repository.TaskDB;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;


public class Task {
    private Long id;
    private String description;
    private Priority priority;
    private boolean isTaken;
    private Long ProgrammerId;
    private boolean statusIsOpen;
    private LocalDateTime createDateTime;
    private LocalDateTime closedDateTime;

    public Task() {
        TaskDB taskDB = new TaskDB();
        Optional<Task> max = taskDB.getAllTasks().stream().max(Comparator.comparing(Task::getId));
        Long maxId = max.get().getId();
        this.id = maxId + 1;
        this.description = "Task" + id;
        this.priority = Priority.LOW;
        this.isTaken = false;
        ProgrammerId = null;
        this.statusIsOpen = true;
        this.createDateTime = LocalDateTime.now();
        this.closedDateTime = null;
    }

    public Task(Long id) {
        this.id = id;
        this.description = null;
        this.priority = null;
        this.isTaken = false;
        ProgrammerId = null;
        this.statusIsOpen = false;
        this.createDateTime = LocalDateTime.now();
        this.closedDateTime = null;

    }

    public Task(Long id, String description, Priority priority, boolean isTaken, Long programmerId, boolean statusIsOpen) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.isTaken = isTaken;
        ProgrammerId = programmerId;
        this.statusIsOpen = statusIsOpen;
        this.createDateTime = LocalDateTime.now();
        this.closedDateTime = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public Long getProgrammerId() {
        return ProgrammerId;
    }

    public void setProgrammerId(Long programmerId) {
        ProgrammerId = programmerId;
    }

    public boolean isStatusIsOpen() {
        return statusIsOpen;
    }

    public void setStatusIsOpen(boolean statusIsOpen) {
        this.statusIsOpen = statusIsOpen;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getClosedDateTime() {
        return closedDateTime;
    }

    public void setClosedDateTime(LocalDateTime closedDateTime) {
        this.closedDateTime = closedDateTime;
    }
}
