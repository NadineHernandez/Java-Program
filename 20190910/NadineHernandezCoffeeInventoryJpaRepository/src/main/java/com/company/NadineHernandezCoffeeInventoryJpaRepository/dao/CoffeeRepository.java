package com.company.NadineHernandezCoffeeInventoryJpaRepository.dao;

import com.company.NadineHernandezCoffeeInventoryJpaRepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findByRoaster(Integer roasterId);
    List<Coffee> findByType(String type);
}
