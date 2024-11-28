package com.example.task_management.repository;

import com.example.task_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTags_Name(String tag);

    List<Task> findByCompleted(boolean completed);
}