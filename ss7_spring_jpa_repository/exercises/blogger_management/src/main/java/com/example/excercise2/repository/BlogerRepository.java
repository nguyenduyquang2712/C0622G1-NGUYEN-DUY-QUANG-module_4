package com.example.excercise2.repository;


import com.example.excercise2.model.Bloger;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogerRepository extends JpaRepository<Bloger, Integer> {

    @Query(value = "select * from Bloger where name like %:keyword%", nativeQuery = true)
    List<Bloger> findByName(@Param("keyword") String nameSearch);
}
