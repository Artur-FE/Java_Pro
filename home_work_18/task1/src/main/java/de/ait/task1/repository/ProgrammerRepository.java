package de.ait.task1.repository;

import de.ait.task1.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
   public List<Programmer> findAll();
   public Optional<Programmer> findById(Long id);
   public Programmer save(Programmer programmer);
}
