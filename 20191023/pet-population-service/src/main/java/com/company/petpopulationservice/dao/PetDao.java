package com.company.petpopulationservice.dao;

import com.company.petpopulationservice.dto.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDao extends JpaRepository <Pet, Integer>{
}
