package com.example.wbdvsu119ashourserverjava.controllers;

import java.util.List;
import java.util.Optional;

import com.example.wbdvsu119ashourserverjava.models.Course;
import com.example.wbdvsu119ashourserverjava.models.Module;
import com.example.wbdvsu119ashourserverjava.repositories.CourseRepository;
import com.example.wbdvsu119ashourserverjava.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
        //grab course from the database using the course id provided in the url 
        Optional<Course> course = courseRepo.findById(id);
        //set course using setter in module
        module.setCourse(course.get());
        //save module using repo
        repository.save(module);
        //return list of modules that have the same course id
        return (List<Module>) repository.findModulesWithCourseId(id);
    }
}