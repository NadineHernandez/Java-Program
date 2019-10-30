package com.company.statesandcities.controller;

import com.company.statesandcities.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CitiesController {
    @RequestMapping(value = "/city", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public City makeCity(@RequestBody @Valid City city){
        City.getCityList().add(city);
        return city;
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public List<City> retrieveCity(){

        return City.getCityList();
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
        @ResponseStatus(HttpStatus.OK)
        public void deleteCity(@PathVariable String name){
        City.setCityList(City.getCityList().stream().filter(c->!c.getName().equals(name)).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public City retrieveCityByName(@PathVariable String name){
        List<City> sortingList = new ArrayList<>();

        sortingList =
        City.getCityList().stream().filter(c->c.getName().equals(name)).collect(Collectors.toList());
        return sortingList.get(0);
    }
}
