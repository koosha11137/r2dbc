package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Courses;
import com.khm.reactivepostgres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Courses> getAllCourses(@RequestParam(required = false) String courseName) {
        if (courseName == null)
            return courseService.findAll();
        else
            return courseService.findByCourseName(courseName);
    }

    @GetMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Courses> getCourseById(@PathVariable("id") int id) {
        return courseService.findById(id);
    }


    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Courses> createCourse(@RequestBody Courses courses) {
        return courseService.save(new Courses(courses.getCourseName(), courses.getCourseCategory(), courses.getPublisher(), courses.getCapacity()));
    }

    @PutMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Courses> updateCourse(@PathVariable("id") int id, @RequestBody Courses courses) {
        return courseService.update(id, courses);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCourse(@PathVariable("id") int id) {
        return courseService.deleteById(id);
    }

    @DeleteMapping("/courses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllCourse() {
        return courseService.deleteAll();
    }
}
