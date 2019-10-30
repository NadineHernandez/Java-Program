package com.company.petpopulationservice.controller;

import com.company.petpopulationservice.dao.PetDao;
import com.company.petpopulationservice.dto.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    private PetDao petDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet createPet(@RequestBody @Valid Pet pet){
        return petDao.save(pet);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pet> getAllPets(){
        return petDao.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pet> getPet(@PathVariable int id){
        return petDao.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updatePet(@RequestBody @Valid Pet pet){
        petDao.save(pet);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletePet(@PathVariable int id){
        petDao.deleteById(id);
    }

}
