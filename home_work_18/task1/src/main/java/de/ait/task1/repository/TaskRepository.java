package de.ait.task1.repository;

import de.ait.task1.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAll();
    public Optional<Task> findById(Long id);
    public Task save(Task task);
}
