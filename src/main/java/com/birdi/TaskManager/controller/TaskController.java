package com.birdi.TaskManager.controller;

 

import com.birdi.TaskManager.model.Task;

import com.birdi.TaskManager.service.TaskService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

 

import java.util.List;

 

@RestController

@RequestMapping("/api/tasks")

public class TaskController {

 

    private final TaskService taskService;

 

    public TaskController(TaskService taskService) {

        this.taskService = taskService;

    }

 

    @GetMapping

    public List<Task> getAllTasks() {

        return taskService.getAllTasks();

    }

 

    @GetMapping("/user/{userId}")

    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {

        List<Task> tasks = taskService.getTasksByUserId(userId);

        return ResponseEntity.ok(tasks);

    }

 

    @PostMapping

    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        Task createdTask = taskService.createTask(task);

        return ResponseEntity.ok(createdTask);

    }

 

    @PutMapping("/{id}")

    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {

        Task updatedTask = taskService.updateTask(id, task);

        return ResponseEntity.ok(updatedTask);

    }

 

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();

    }

}