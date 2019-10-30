package com.company.NadineHernandezU1Capstone.controller;

import com.company.NadineHernandezU1Capstone.dto.Console;
import com.company.NadineHernandezU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
        return serviceLayer.saveConsole(console);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsoles(){
        try {int tester = serviceLayer.findAllConsoles().get(0).getConsole_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Consoles not found", e);
        }
       return serviceLayer.findAllConsoles();
    }

    @RequestMapping(value = "/{console_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Console getConsole(@PathVariable int console_id){
        try {int tester = serviceLayer.findConsole(console_id).getConsole_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Console not found", e);
        }
            return serviceLayer.findConsole(console_id);

    }

    @RequestMapping(value = "/{console_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateConsole(@PathVariable int console_id, @RequestBody @Valid Console console){
        console.setConsole_id(console_id);
        serviceLayer.updateConsole(console);
    }

    @RequestMapping(value = "/{console_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteConsole(@PathVariable int console_id){
        serviceLayer.removeConsole(console_id);
    }

    @RequestMapping(value = "/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> findConsolesByManufacturer(@PathVariable String manufacturer){
        try {int tester = serviceLayer.findConsolesByManufacturer(manufacturer).get(0).getConsole_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Consoles not found", e);
        }
        return serviceLayer.findConsolesByManufacturer(manufacturer);
    }
}
