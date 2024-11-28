package com.example.task_management.controller;
import com.example.task_management.model.Tag;
import com.example.task_management.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("auth/tags")
public class TagController {
 @Autowired
 private TagService tagService;
 @GetMapping
 public List<Tag> getAllTags() {
 return tagService.getAllTags();
 }
 @PostMapping
 public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
 return new ResponseEntity<>(tagService.createTag(tag), HttpStatus.CREATED);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
 tagService.deleteTag(id);
 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}