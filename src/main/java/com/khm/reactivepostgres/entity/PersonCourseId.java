package com.khm.reactivepostgres.entity;

import java.io.Serializable;

public class PersonCourseId implements Serializable {

    private int personId;

    private int courseId;

    public PersonCourseId() {
    }

    public PersonCourseId(int personId, int courseId) {
        this.personId = personId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Person_course [ personid=" + personId + ", courseid=" + courseId + "]";
    }
}
