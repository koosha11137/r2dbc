package com.khm.reactivepostgres.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.IdClass;

@Getter
@Setter
@IdClass(PersonCourseId.class)
public class PersonCourse {
    @Id
    private int id;
    @Column("person_id")
    private int personId;

    @Column("course_id")
    private int courseId;

    public PersonCourse() {
    }

    public PersonCourse(int personId, int courseId) {
        this.personId = personId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "person_course [ id=" + id + ",personid=" + personId + ", course_id=" + courseId + "]";
    }
}
