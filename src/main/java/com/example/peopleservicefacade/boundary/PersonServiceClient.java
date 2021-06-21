package com.example.peopleservicefacade.boundary;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import com.example.peopleservicefacade.entity.Person;

@FeignClient(name = "people", url = "${rest.person-service.url}")
public interface PersonServiceClient {

    @GetMapping("/v1/people")
    List<Object> getPeople();

    @GetMapping("/v1/people/{id}")
    Object getPerson(@PathVariable("id") Long id);

    @PostMapping
    Object newPerson(Person person);

    @PutMapping("{id}")
    Object updatePerson(@PathVariable("id") Long id, Person person);
}
