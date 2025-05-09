package de.ait.task_1.repository;

import de.ait.task_1.model.Priority;
import de.ait.task_1.model.Programmer;
import de.ait.task_1.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgrammersDB implements ProgrammerRepository {

    private static HashMap<Long, Programmer> programmers = new HashMap<>();

    static {
        programmers.put(1L, new Programmer(1L, "Programmer1", new ArrayList<Task>()));
        programmers.put(2L, new Programmer(2L, "Programmer2", new ArrayList<Task>()));
        programmers.put(3L, new Programmer(3L, "Programmer3", new ArrayList<Task>()));
        programmers.put(4L, new Programmer(4L, "Programmer4", new ArrayList<Task>()));
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        return programmers.values().stream().toList();
    }

    @Override
    public Programmer getProgrammerById(Long id) {
        return programmers.get(id) != null ? programmers.get(id) : new Programmer(-1L);
    }

    @Override
    public List<Task> getTaskProgrammerById(Long id) {
        return programmers.get(id) != null ? programmers.get(id).getTasks() : new ArrayList<Task>(
                List.of(new Task(-1l))
        );
    }

    @Override
    public Task addIdTaskProgrammerById(Long idTask, Long idProgrammer) {
        try {

            Task task = TaskDB.tasks.get(idTask);
            if (!task.isTaken() && task.isStatusIsOpen()) {
                task.setTaken(true);
                task.setProgrammerId(idProgrammer);
                Programmer programmer = programmers.get(idProgrammer);
                programmer.getTasks().add(task);
                programmers.put(idProgrammer, programmer);
                return task;
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            return new Task(-1L);
        }
    }

    @Override
    public boolean addProgrammer(Programmer programmer) {
        if (programmers.get(programmer.getId()) != null) {
            return false;
        } else {
            programmers.put(programmer.getId(), programmer);
            return true;
        }
    }

    @Override
    public Programmer deleteIdTaskProgrammerById(Long idTask, Long idProgrammer) {
        if (programmers.get(idProgrammer) != null &&
                programmers.get(idProgrammer)
                        .getTasks()
                        .stream()
                        .anyMatch(task -> task.getId().equals(idTask))) {

            Programmer programmer = programmers.get(idProgrammer);
            List<Task> tasks = programmer.getTasks();
            tasks.stream().filter(task-> task.getId() == idTask)
                            .forEach(task -> task.setStatusIsOpen(false));
            tasks.stream().filter(task-> task.getId() == idTask)
                    .forEach(task -> task.setTaken(false));
            tasks.removeIf(task -> task.getId() == idTask);

            return programmers.get(idProgrammer);
        } else {
            return new Programmer(-1L);
        }
    }
}
