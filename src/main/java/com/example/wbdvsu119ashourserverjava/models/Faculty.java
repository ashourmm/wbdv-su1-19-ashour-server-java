package com.example.wbdvsu119ashourserverjava.models;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Faculty extends User {
    private Boolean tenured;
    private String office;

    @OneToMany(mappedBy = "author")
    private List<Course> authoredCourses;

    public List<Course> getAuthoredCourses() {
        return authoredCourses;
    }

    public void setAuthoredCourses(List<Course> authoredCourses) {
        this.authoredCourses = authoredCourses;
    }

    public Boolean getTenured() {
        return tenured;
    }

    public void setTenured(Boolean tenured) {
        this.tenured = tenured;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}