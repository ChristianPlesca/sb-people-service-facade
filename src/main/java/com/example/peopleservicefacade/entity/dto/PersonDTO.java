package com.example.peopleservicefacade.entity.dto;

import com.example.peopleservicefacade.entity.Person;

import lombok.Data;


@Data
public class PersonDTO {

    private Person person;
    private CountryInfo countryInfo;
}
