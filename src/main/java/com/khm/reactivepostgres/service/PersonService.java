package com.khm.reactivepostgres.service;

import com.khm.reactivepostgres.entity.Persons;
import com.khm.reactivepostgres.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Flux<Persons> findAll() {
        return personRepository.findAll();
    }

    public Flux<Persons> findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }


    public Mono<Persons> findById(int id) {
        return personRepository.findById(id);
    }

    public Mono<Persons> save(Persons persons) {
        return personRepository.save(persons);
    }

    public Mono<Persons> update(int id, Persons persons) {
        return personRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        persons.setId(id);
                        return personRepository.save(persons);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(int id) {
        return personRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return personRepository.deleteAll();
    }

}
