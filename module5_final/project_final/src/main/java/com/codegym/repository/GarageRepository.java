package com.codegym.repository;

import com.codegym.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage,Integer> {
    @Query(value="select * from `garage` where status =1", nativeQuery = true)
    List<Garage> findAll();
}
