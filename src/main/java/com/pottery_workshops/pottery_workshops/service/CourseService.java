package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.Course;
import com.pottery_workshops.pottery_workshops.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
