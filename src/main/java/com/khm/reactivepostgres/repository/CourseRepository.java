package com.khm.reactivepostgres.repository;


import com.khm.reactivepostgres.entity.Courses;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CourseRepository extends R2dbcRepository<Courses, Integer> {

    Mono<Courses> findById(int id);
    Flux<Courses> findAllByCourseName(String courseName);
    Flux<Courses> findAllByCourseCategory(String courseCategory);

}

