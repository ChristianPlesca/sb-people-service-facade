package com.example.peopleservicefacade.entity.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CountryInfo {

    public String name;
    public String capital;
    public String region;
    public String alpha2Code;
    public String[] altSpellings;
    public List<Map<String, String>> languages;
    
}