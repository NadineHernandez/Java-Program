package com.example.restcalculatorservice.controller;

import com.example.restcalculatorservice.model.Operands;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCalculatorServiceController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int add(@RequestBody Operands operands) {

        return operands.getOperand1() + operands.getOperand2();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int subtract(@RequestBody Operands operands) {

        return operands.getOperand1() - operands.getOperand2();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int multiply(@RequestBody Operands operands) {

        return operands.getOperand1() * operands.getOperand2();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public float divide(@RequestBody Operands operands) {

        return (float)operands.getOperand1() / (float)operands.getOperand2();
    }


}
