package com.example.wbdvsu119ashourserverjava.models;
import javax.persistence.Entity;

@Entity
public class Student extends User {
    private Float gpa;
    private Integer graduatingYear;

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Integer getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(Integer graduatingYear) {
        this.graduatingYear = graduatingYear;
    }
}