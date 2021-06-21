package com.example.peopleservicefacade.boundary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.example.peopleservicefacade.entity.Person;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "v1/people")
public class PersonFacade {

    @Autowired
    PersonServiceClient personServiceClient;

    @GetMapping
    public List<Person> getPeople() {

        return personServiceClient.getPeople();
    }

    @GetMapping("{id}")
    public Person getPerson(@PathVariable("id") Long id) {

        return personServiceClient.getPerson(id);
    }

    @PostMapping
    public Person newPerson(@RequestBody @Valid Person person) {

        return personServiceClient.newPerson(person);
    }

    @PutMapping("{id}")
    public Person updatePerson(@PathVariable("id")Long id, @RequestBody Person person) {

        return personServiceClient.updatePerson(id, person);
    }
}
