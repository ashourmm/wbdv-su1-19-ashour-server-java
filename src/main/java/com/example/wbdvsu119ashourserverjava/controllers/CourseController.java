package com.example.wbdvsu119ashourserverjava.controllers;

import com.example.wbdvsu119ashourserverjava.models.Course;
import com.example.wbdvsu119ashourserverjava.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository repository;

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return (List<Course>)repository.findAll();
    }
}