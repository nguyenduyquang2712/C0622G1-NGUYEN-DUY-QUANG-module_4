package com.codegym.service.impl;

import com.codegym.model.Course;
import com.codegym.repository.CourseRepository;
import com.codegym.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService implements ICourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
