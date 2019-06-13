package com.example.wbdvsu119ashourserverjava.controllers;

import com.example.wbdvsu119ashourserverjava.models.Course;
import com.example.wbdvsu119ashourserverjava.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseRepository repository;

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return (List<Course>)repository.findAll();
    }
    @GetMapping("/api/courses/{id}")
    public Course findById(@PathVariable("id") int id) {
        Optional<Course> data= repository.findById(id);
        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    @PostMapping("/api/courses")
    public List<Course> createCourse(@RequestBody Course course) {
        repository.save(course);
        return (List<Course>)repository.findAll();
    }

    @DeleteMapping("api/coures/{id}")
    public void deleteCourse(@PathVariable("id") int id) {
        repository.deleteById(id);

    }

    @PutMapping("api/courses/{id}")
    public Course updateCourse(@PathVariable("id") int id,
    @RequestBody Course course) {
        Course updatedCourse = repository.findById(id).get();
        updatedCourse.setTitle(course.getTitle());
        repository.save(updatedCourse);
        return updatedCourse;
    }



}