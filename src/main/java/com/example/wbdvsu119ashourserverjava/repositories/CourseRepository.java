package com.example.wbdvsu119ashourserverjava.repositories;

import com.example.wbdvsu119ashourserverjava.models.Course;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository
    extends CrudRepository<Course, Integer> {

        @Query(value="select c from course where (c.id=:id)", nativeQuery = true)
            public Course findCourseById(
                @Param("id") Integer courseId);
}