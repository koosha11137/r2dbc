package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.PersonCourse;
import com.khm.reactivepostgres.entity.Persons;
import com.khm.reactivepostgres.repository.PersonCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonCourseService {
    @Autowired
    PersonCourseRepository personCourseRepository;

    public Mono<PersonCourse> save(PersonCourse personCourse) {
        return personCourseRepository.save(personCourse);
    }

    public Flux<Persons> findPersonByCourseId(int id) {
        return personCourseRepository.findById(id);
    }

}
