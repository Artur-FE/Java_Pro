package de.ait.tasks.service;

import de.ait.tasks.dto.TaskRequestDto;
import de.ait.tasks.model.Task;

public interface TaskService {
   public Task addTask(TaskRequestDto task);
}
