package com.cvgenerator.service.map;

import com.cvgenerator.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseMapServiceTest {

    CourseMapService courseMapService;
    Course course;
    Long courseId = 1L;

    @BeforeEach
    void setUp() {
        courseMapService = new CourseMapService();

        course = Course.builder().id(courseId).name("course 1").build();

        courseMapService.save(course);
    }

    @Test
    void findAll() {
        Set<Course> courses = courseMapService.findAll();

        assertEquals(1, courses.size());
    }

    @Test
    void findById() {
        Course foundCourse = courseMapService.findById(courseId);

        assertEquals(course.getId(), foundCourse.getId());
        assertEquals(course.getName(), foundCourse.getName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String courseName = "course 2";
        Course savedCourse = courseMapService.save(Course.builder().id(id).name(courseName).build());

        assertNotNull(savedCourse);
        assertEquals(id, savedCourse.getId());
        assertEquals(courseName, savedCourse.getName());
    }

    @Test
    void saveNoId() {
        String courseName = "course 3";
        Course savedCourse = courseMapService.save(Course.builder().name(courseName).build());

        assertNotNull(savedCourse);
        assertNotNull(savedCourse.getId());
        assertEquals(courseName, savedCourse.getName());

    }

    @Test
    void delete() {
        courseMapService.delete(course);

        assertEquals(0, courseMapService.findAll().size());
    }

    @Test
    void deleteById() {
        courseMapService.deleteById(courseId);

        assertEquals(0, courseMapService.findAll().size());
    }
}