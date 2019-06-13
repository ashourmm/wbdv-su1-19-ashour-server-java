package com.example.wbdvsu119ashourserverjava.controllers;

import java.util.List;
import java.util.Optional;

import com.example.wbdvsu119ashourserverjava.models.Course;
import com.example.wbdvsu119ashourserverjava.models.Module;
import com.example.wbdvsu119ashourserverjava.repositories.CourseRepository;
import com.example.wbdvsu119ashourserverjava.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ModuleController {
    @Autowired
    ModuleRepository repository;

    @Autowired
    CourseRepository courseRepo;

    @GetMapping("/api/courses/{courseId}/modules")
    public List<Module> findModulesForCourse(@PathVariable("courseId") Integer id) {
        return (List<Module>) repository.findModulesWithCourseId(id);
    }
    @PostMapping("/api/courses/{courseId}/modules")
    public List<Module> createModule(
        @RequestBody Module module,
        @PathVariable("courseId") Integer id) {
        Optional<Course> course = courseRepo.findById(id);
        module.setCourse(course.get());
        repository.save(module);
        return (List<Module>) repository.findModulesWithCourseId(id);
    }

    @DeleteMapping("/api/modules/{moduleId}")
    public List<Module> deleteModule(
        @PathVariable("moduleId") Integer id) {
        repository.deleteById(id);
        return null;

    }
}