package com.cvgenerator.service.map;

import com.cvgenerator.model.Course;
import com.cvgenerator.service.CourseService;

import java.util.Set;

public class CourseMapService extends AbstractMapService<Course, Long> implements CourseService {

    @Override
    public Set<Course> findAll() {
        return super.findAll();
    }

    @Override
    public Course findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Course save(Course object) {
        return super.save(object);
    }

    @Override
    public void delete(Course object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
