package com.example.peopleservicefacade.entity.dto;

import com.example.peopleservicefacade.entity.Person;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PersonDTO {

    private Person person;
    private CountryInfo countryInfo;
}
