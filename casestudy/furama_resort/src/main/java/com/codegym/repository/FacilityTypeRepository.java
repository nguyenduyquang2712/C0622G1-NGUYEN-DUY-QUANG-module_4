package com.codegym.repository;

import com.codegym.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType,Integer> {

}
