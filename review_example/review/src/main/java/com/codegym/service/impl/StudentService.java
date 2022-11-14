package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Page<Student> findAllByNameAndClassName(String studentName, String className, Pageable pageable) {
        return studentRepository.findAllByNameAndClassName(studentName, className, pageable);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        studentRepository.remove(id);
    }
}
