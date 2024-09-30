package com.birdi.TaskManager.service;

 

import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.birdi.TaskManager.model.Task;

import com.birdi.TaskManager.repository.TaskRepository;

 

@Service

public class TaskService {

    private final TaskRepository taskRepository;

 

    public TaskService(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;

    }

 

    public List<Task> getAllTasks() {

        return taskRepository.findAll();

    }

 

    public List<Task> getTasksByUserId(Long userId) {

        return taskRepository.findByUserId(userId);

    }

 

    public Task createTask(Task task) {

        return taskRepository.save(task);

    }

 

    public Task updateTask(Long id, Task updatedTask) {

        return taskRepository.findById(id).map(task -> {

            task.setTitle(updatedTask.getTitle());

            task.setDescription(updatedTask.getDescription());

            task.setDueDate(updatedTask.getDueDate());

            task.setStatus(updatedTask.getStatus());

            return taskRepository.save(task);

        }).orElseThrow(() -> new RuntimeException("Task not found"));

    }

 

    public void deleteTask(Long id) {

        taskRepository.deleteById(id);

    }

}

 