package com.example.wbdvsu119ashourserverjava.repositories;

import com.example.wbdvsu119ashourserverjava.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository
    extends CrudRepository<Course, Integer> {
}