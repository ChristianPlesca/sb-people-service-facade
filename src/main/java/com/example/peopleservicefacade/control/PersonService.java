package com.example.peopleservicefacade.control;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import com.example.peopleservicefacade.boundary.PersonServiceClient;
import com.example.peopleservicefacade.boundary.RestCountriesClient;
import com.example.peopleservicefacade.entity.Person;
import com.example.peopleservicefacade.entity.dto.CountryInfo;
import com.example.peopleservicefacade.entity.dto.PersonDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {

    @Autowired
    private PersonServiceClient personServiceClient;

    @Autowired
    private RestCountriesClient restCountriesClient;

    public List<PersonDTO> getPeople() {
        
        return personServiceClient.getPeople().stream()
                .map(person -> buildDTO(person))
                .collect(Collectors.toList());
    }

    public PersonDTO getPerson(Long id) {

        return buildDTO(personServiceClient.getPerson(id));
    }

    private PersonDTO buildDTO(Person person) {

        CountryInfo countryInfo = restCountriesClient.getCountry(person.getCountryCode());
        return new PersonDTO(person, countryInfo);
    }
    
}