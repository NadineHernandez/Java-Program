package com.company.weather.controller;

import com.company.weather.model.Conditions;
import com.company.weather.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Temperature retrieveTemperature(@PathVariable String zipcode){
        Temperature temperature = new Temperature();
        //code for retrieving temperature object at zipcode. Using weather api?
        temperature.setCelsius(0);
        temperature.setFahrenheit(32);
        return temperature;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Conditions retrieveConditions(@PathVariable String zipcode){
        Conditions conditions = new Conditions();
        //code for retrieving conditions object at zipcode.
        conditions.setCelsius(0);
        conditions.setFahrenheit(32);
        conditions.setWindSpeed(15);
        conditions.setWindDirection("North");
        conditions.setSkies("Cloudy");
        conditions.setPrecipitation("Snowing");
        return conditions;
    }
}
