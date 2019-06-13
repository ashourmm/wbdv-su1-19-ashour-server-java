package com.example.wbdvsu119ashourserverjava.repositories;

import java.util.List;

import com.example.wbdvsu119ashourserverjava.models.Module;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository
extends CrudRepository<Module, Integer> {

    //implement method to query modules that have the same given course id
    @Query(value="select * from modules where course_id=:courseId", nativeQuery = true)
    public List<Module> findModulesWithCourseId(@Param("courseId") Integer courseId);

}