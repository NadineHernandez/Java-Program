package com.company.restcalculator.controller;

import com.company.restcalculator.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestCalculatorController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int add(@RequestBody  @Valid Calculator calculator){
        return calculator.add(calculator.getOperand1(), calculator.getOperand2());
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int subtract(@RequestBody @Valid Calculator calculator){
        return calculator.subtract(calculator.getOperand1(), calculator.getOperand2());
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int multiply(@RequestBody @Valid Calculator calculator){
        return calculator.multiply(calculator.getOperand1(), calculator.getOperand2());
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public float divide(@RequestBody @Valid Calculator calculator){
        return calculator.divide(calculator.getOperand1(), calculator.getOperand2());
    }
}
