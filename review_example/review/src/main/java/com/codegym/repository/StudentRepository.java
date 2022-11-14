package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value="select s.* from `student` s  left join `class_room`  cr   \n" +
            "on s.class_id = cr.id \n" +
            "WHERE s.name like %:name% and cr.name like %:className% and s.`status`=1", nativeQuery = true)
    Page<Student> findAllByNameAndClassName(@Param("name") String name,
                                            @Param("className") String className,
                                            Pageable pageable);
    @Transactional
    @Modifying
    @Query(value="update student s set s.`status`=0 where s.id= :id", nativeQuery = true)
    void remove (@Param("id") int id);
}
