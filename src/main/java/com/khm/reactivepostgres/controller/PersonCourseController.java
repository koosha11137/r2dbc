package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.PersonCourse;
import com.khm.reactivepostgres.entity.Persons;
import com.khm.reactivepostgres.service.PersonCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonCourseController {
    @Autowired
    PersonCourseService personCourseService;

    @PostMapping("/person_course")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PersonCourse> createPersonCourse(@RequestBody PersonCourse personCourse) {
        return personCourseService.save(new PersonCourse(personCourse.getPersonId(), personCourse.getCourseId()));
    }
    @GetMapping("/attendInCourse/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Persons> getPersonAttendInCourse(@PathVariable("id") int id) {
        return personCourseService.findPersonByCourseId(id);
    }
}
