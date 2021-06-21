package com.example.peopleservicefacade.boundary;

import com.example.peopleservicefacade.boundary.CountryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "countires", url = "${rest.person-service.url}")
public interface RestCountriesClient {

    @GetMapping("/v2/alpha/{code}")
    CountryInfo getCountry(@PathVariable("code") String code);
}