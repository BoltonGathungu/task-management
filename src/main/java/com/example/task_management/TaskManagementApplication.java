package com.example.task_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Task Management application.
 * This class is responsible for bootstrapping the Spring Boot application.
 */
@SpringBootApplication
public class TaskManagementApplication {

    /**
     * The main method that serves as the entry point for the Java application.
     *
     * @param args Command-line arguments passed to the application (not used).
     */
    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
    }
}