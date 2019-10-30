package com.example.helloservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloServiceController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greeting(@PathVariable String name) {
        return "Hello, " + name + "!!!";
    }
}
