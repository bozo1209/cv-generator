package com.cvgenerator.service.map;

import com.cvgenerator.model.Education;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EducationMapServiceTest {

    EducationMapService educationMapService;
    Education education;
    Long educationId = 1L;

    @BeforeEach
    void setUp() {
        educationMapService = new EducationMapService();

        education = Education.builder().id(educationId).schoolName("education 1").build();

        educationMapService.save(education);
    }

    @Test
    void findAll() {
        Set<Education> educations = educationMapService.findAll();

        assertEquals(1, educations.size());
    }

    @Test
    void findById() {
        Education foundEducation = educationMapService.findById(educationId);

        assertEquals(educationId, foundEducation.getId());
        assertEquals(education.getSchoolName(), foundEducation.getSchoolName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String schoolName = "education 2";
        Education savedEducation = educationMapService.save(Education.builder().id(id).schoolName(schoolName).build());

        assertNotNull(savedEducation);
        assertEquals(id, savedEducation.getId());
        assertEquals(schoolName, savedEducation.getSchoolName());
    }

    @Test
    void saveNoId() {
        String schoolName = "education 2";
        Education savedEducation = educationMapService.save(Education.builder().schoolName(schoolName).build());

        assertNotNull(savedEducation);
        assertNotNull(savedEducation.getId());
        assertEquals(schoolName, savedEducation.getSchoolName());
    }

    @Test
    void delete() {
        educationMapService.delete(education);

        assertEquals(0, educationMapService.findAll().size());
    }

    @Test
    void deleteById() {
        educationMapService.deleteById(educationId);

        assertEquals(0, educationMapService.findAll().size());
    }
}