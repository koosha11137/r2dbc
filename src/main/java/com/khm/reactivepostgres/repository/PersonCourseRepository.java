package com.khm.reactivepostgres.repository;

import com.khm.reactivepostgres.entity.PersonCourse;
import com.khm.reactivepostgres.entity.Persons;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonCourseRepository extends R2dbcRepository<PersonCourse, Integer> {
    @Query("select * from persons t where t.id in (select person_id from person_course p where p.course_id=:id)")
    Flux<Persons> findById(int id);

}
