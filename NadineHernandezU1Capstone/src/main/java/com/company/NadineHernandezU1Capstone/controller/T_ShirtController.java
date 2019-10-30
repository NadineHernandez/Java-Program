package com.company.NadineHernandezU1Capstone.controller;

import com.company.NadineHernandezU1Capstone.dto.T_Shirt;
import com.company.NadineHernandezU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirt")
public class T_ShirtController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public T_Shirt createT_Shirt(@RequestBody @Valid T_Shirt t_shirt){
        return serviceLayer.saveT_Shirt(t_shirt);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> getAllT_Shirts(){
        try {int tester = serviceLayer.findAllT_Shirts().get(0).getT_shirt_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "T-shirts not found", e);
        }
        return serviceLayer.findAllT_Shirts();
    }

    @RequestMapping(value = "/{t_shirt_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public T_Shirt getT_Shirt(@PathVariable int t_shirt_id){
        try {int tester = serviceLayer.findT_Shirt(t_shirt_id).getT_shirt_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "T-shirt not found", e);
        }
        return serviceLayer.findT_Shirt(t_shirt_id);
    }

    @RequestMapping(value = "/{t_shirt_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateT_Shirt(@PathVariable int t_shirt_id, @RequestBody @Valid T_Shirt t_shirt){
        t_shirt.setT_shirt_id(t_shirt_id);
        serviceLayer.updateT_Shirt(t_shirt);
    }

    @RequestMapping(value = "/{t_shirt_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteT_Shirt(@PathVariable int t_shirt_id){
        serviceLayer.removeT_Shirt(t_shirt_id);
    }

    @RequestMapping(value = "/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> findT_ShirtsByColor(@PathVariable String color){
        try {int tester = serviceLayer.findT_ShirtsByColor(color).get(0).getT_shirt_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "T-shirts not found", e);
        }
        return serviceLayer.findT_ShirtsByColor(color);
    }

    @RequestMapping(value = "/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T_Shirt> findT_ShirtsBySize(@PathVariable String size){
        try {int tester = serviceLayer.findT_ShirtsBySize(size).get(0).getT_shirt_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "T-shirts not found", e);
        }
        return serviceLayer.findT_ShirtsBySize(size);
    }
}
