package com.company.restcalculator.controller;

import com.company.restcalculator.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCalculatorController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int add(@RequestBody Calculator calculator){
        return calculator.add(calculator.getOperand1(), calculator.getOperand2());
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int subtract(@RequestBody Calculator calculator){
        return calculator.subtract(calculator.getOperand1(), calculator.getOperand2());
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int multiply(@RequestBody Calculator calculator){
        return calculator.multiply(calculator.getOperand1(), calculator.getOperand2());
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public float divide(@RequestBody Calculator calculator){
        return calculator.divide(calculator.getOperand1(), calculator.getOperand2());
    }
}
