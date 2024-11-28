package com.example.task_management.repository;

import com.example.task_management.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    // Additional query methods can be defined here, if needed
}