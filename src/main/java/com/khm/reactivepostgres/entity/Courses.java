package com.khm.reactivepostgres.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class Courses {
    @Id
    private int id;

@Column("course_name")
    private String courseName;

@Column("course_category")
    private String courseCategory;

    private String publisher;

    private Integer capacity;

    public Courses(String courseName, String courseCategory, String publisher, Integer capacity) {
        this.courseName = courseName;
        this.courseCategory = courseCategory;
        this.publisher = publisher;
        this.capacity = capacity;
    }

    public Courses() {
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", coursename=" + courseName + ", coursecategory=" + courseCategory + ", publisher=" + publisher +", capacity="+capacity+ "]";
    }
}
