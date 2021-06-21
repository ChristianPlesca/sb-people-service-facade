package com.example.peopleservicefacade.control;

import lombok.extern.slf4j.Slf4j;

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

    public PersonDTO getPerson(Long id) {

        Person person = personServiceClient.getPerson(id);
        CountryInfo countryInfo = restCountriesClient.getCountry(person.getCountryCode());

        return new PersonDTO(person, countryInfo);
    }
    
}