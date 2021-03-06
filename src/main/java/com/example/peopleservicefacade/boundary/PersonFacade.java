package com.example.peopleservicefacade.boundary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.example.peopleservicefacade.control.PersonService;
import com.example.peopleservicefacade.entity.Person;
import com.example.peopleservicefacade.entity.dto.PersonDTO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "v1/people")
public class PersonFacade {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<PersonDTO> getPeople() {

        return personService.getPeople();
    }

    @GetMapping("{id}")
    public PersonDTO getPerson(@PathVariable("id") Long id) {

        return personService.getPerson(id);
    }

    @PostMapping
    public PersonDTO newPerson(@RequestBody @Valid Person person) {

        return personService.newPerson(person);
    }

    @PutMapping("{id}")
    public PersonDTO updatePerson(@PathVariable("id")Long id, @RequestBody Person person) {

        return personService.updatePerson(id, person);
    }
}
