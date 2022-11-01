package com.codegym.repository;


import com.codegym.model.Bloger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BlogerRepository extends JpaRepository<Bloger, Integer> {

    Page<Bloger> findAllByNameContainingOrderByDateDesc(String blogName, Pageable pageable);

    @Query(value = "SELECT * FROM bloger join category\n" +
            "on bloger.category_id = category.id\n" +
            "where category.name = :nameCategory",nativeQuery = true)
    List<Bloger> findAllByCategory(@Param("nameCategory") String nameCategory);
}
