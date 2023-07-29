package com.khm.reactivepostgres.controller;

import com.khm.reactivepostgres.entity.Persons;
import com.khm.reactivepostgres.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Persons> getAllPersons(@RequestParam(required = false) String lastName) {
        if (lastName == null)
            return personService.findAll();
        else
            return personService.findByLastName(lastName);
    }

    @GetMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Persons> getPersonById(@PathVariable("id") int id) {
        return personService.findById(id);
    }


    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Persons> createPerson(@RequestBody Persons persons) {
        return personService.save(new Persons(persons.getFirstName(), persons.getLastName(), persons.getPhoneNumber()));
    }

    @PutMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Persons> updatePerson(@PathVariable("id") int id, @RequestBody Persons persons) {
        return personService.update(id, persons);
    }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletepPerson(@PathVariable("id") int id) {
        return personService.deleteById(id);
    }

    @DeleteMapping("/persons")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllPersons() {
        return personService.deleteAll();
    }

}
