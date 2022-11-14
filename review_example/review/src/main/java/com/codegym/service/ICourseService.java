package com.codegym.service;

import com.codegym.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
}
