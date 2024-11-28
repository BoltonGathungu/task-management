package com.example.task_management.controller;
import com.example.task_management.model.Task;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("auth/tasks")
public class TaskController {
 @Autowired
 private TaskService taskService;
 @GetMapping
 public List<Task> getAllTasks() {
 return taskService.getAllTasks();
 }
 @PostMapping
 public ResponseEntity<Task> createTask(@RequestBody Task task) {
 return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
 }
 @PutMapping("/{id}")
 public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task 
task) {
 return new ResponseEntity<>(taskService.updateTask(id, task), HttpStatus.OK);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
 taskService.deleteTask(id);
 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
 @GetMapping("/filter")
 public List<Task> filterTasks(@RequestParam boolean completed) {
 return taskService.filterTasks(completed);
 }
}