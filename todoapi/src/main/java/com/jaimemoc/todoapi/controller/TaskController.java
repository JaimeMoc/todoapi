package com.jaimemoc.todoapi.controller;

import com.jaimemoc.todoapi.model.Task;
import com.jaimemoc.todoapi.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return repository.save(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}