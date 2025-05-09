package de.ait.task_1.controller;

import de.ait.task_1.model.Programmer;
import de.ait.task_1.model.Task;
import de.ait.task_1.repository.ProgrammerRepository;
import de.ait.task_1.repository.ProgrammersDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgrammerController {
    ProgrammerRepository programmersDB = new ProgrammersDB();

    @GetMapping("/programmers")
    public List<Programmer> getAllProgrammers(){
        return programmersDB.getAllProgrammers();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammersById(@PathVariable(value = "id") Long id){
        return programmersDB.getProgrammerById(id);
    }

    @GetMapping("/programmers/{id}/task")
    public List<Task> getTaskProgrammerById(@PathVariable(value = "id") Long id){
        return programmersDB.getTaskProgrammerById(id);
    }

    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public Task addIdTaskProgrammerById(@PathVariable(value = "taskId") Long idTask,
                                        @PathVariable(value = "programmerId") Long idProgrammer){
        return programmersDB.addIdTaskProgrammerById(idTask, idProgrammer);
    }

    @PostMapping("/addProgrammer")
    public boolean addProgrammer(@RequestBody Programmer programmer){
        return programmersDB.addProgrammer(programmer);
    }

    @DeleteMapping("/programmers/{programmerId}/tasks/{taskId}")
    public Programmer deleteIdTaskProgrammerById(@PathVariable(value = "taskId") Long idTask,
                                                 @PathVariable(value = "programmerId") Long idProgrammer){
        return programmersDB.deleteIdTaskProgrammerById(idTask, idProgrammer);
    }
}
