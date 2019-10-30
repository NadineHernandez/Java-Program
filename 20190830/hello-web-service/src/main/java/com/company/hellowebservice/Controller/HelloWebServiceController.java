package com.company.hellowebservice.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWebServiceController {
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String hello(@PathVariable String name){
        return "Hello, " + name;
    }
}
