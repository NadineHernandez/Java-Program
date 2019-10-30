package com.company.randomgreetingservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class RandomGreetingServiceController {
    private List<String> greetingList = new ArrayList<>();

    private Random rndGenerator = new Random();

    public RandomGreetingServiceController(){
        greetingList.add("Hiya");
        greetingList.add("Hello!!!");
        greetingList.add("Howdy");
        greetingList.add("We come in peace");
        greetingList.add("Hi");
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)

    public String getRandomGreeting(){
        int whichGreeting = rndGenerator.nextInt(5);
        return greetingList.get(whichGreeting);
    }
}
