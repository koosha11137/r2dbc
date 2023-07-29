package com.khm.reactivepostgres.repository;

import com.khm.reactivepostgres.entity.Persons;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends R2dbcRepository<Persons, Integer> {
    Mono<Persons> findById(int id);

    Flux<Persons> findByLastName(String lastName);
}
