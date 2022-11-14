package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Page<Student> findAllByNameAndClassName(String studentName, String className, Pageable pageable);
    List<Student> findAll();
    void save(Student student);
    Optional<Student> findById(int id);
    void remove(int id);

}
