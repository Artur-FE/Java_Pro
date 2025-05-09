package de.ait.task_1.repository;

import de.ait.task_1.model.Programmer;
import de.ait.task_1.model.Task;

import java.util.List;

public interface ProgrammerRepository {
    public List<Programmer> getAllProgrammers();
    public Programmer getProgrammerById(Long id);
    public List<Task> getTaskProgrammerById(Long id);
    public Task addIdTaskProgrammerById(Long idTask, Long idProgrammer);
    public boolean addProgrammer(Programmer programmer);
    public Programmer deleteIdTaskProgrammerById(Long idTask, Long idProgrammer);
}
