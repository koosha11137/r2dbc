package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Courses;
import com.khm.reactivepostgres.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Flux<Courses> findAll() {
        return courseRepository.findAll();
    }

    public Flux<Courses> findByCourseName(String courseName) {
        return courseRepository.findAllByCourseName(courseName);
    }

    public Flux<Courses> findByCourseCategory(String courseCategory) {
        return courseRepository.findAllByCourseCategory(courseCategory);
    }


    public Mono<Courses> findById(int id) {
        return courseRepository.findById(id);
    }

    public Mono<Courses> save(Courses courses) {
        return courseRepository.save(courses);
    }

    public Mono<Courses> update(Integer id, Courses courses) {
        return courseRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        courses.setId(id);
                        return courseRepository.save(courses);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(Integer id) {
        return courseRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return courseRepository.deleteAll();
    }

}
