package com.cvgenerator.service.map;

import com.cvgenerator.model.Experience;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExperienceMapServiceTest {

    ExperienceMapService experienceMapService;
    Experience experience;
    Long experienceId = 1L;

    @BeforeEach
    void setUp() {
        experienceMapService = new ExperienceMapService();

        experience = Experience.builder().id(experienceId).companyName("experience 1").build();

        experienceMapService.save(experience);
    }

    @Test
    void findAll() {
        Set<Experience> experiences = experienceMapService.findAll();

        assertEquals(1, experiences.size());
    }

    @Test
    void findById() {
        Experience foundExperience = experienceMapService.findById(experienceId);

        assertEquals(experienceId, foundExperience.getId());
        assertEquals(experience.getCompanyName(), foundExperience.getCompanyName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String companyName = "experience 2";
        Experience savedExperience = experienceMapService.save(Experience.builder().id(id).companyName(companyName).build());

        assertNotNull(savedExperience);
        assertEquals(id, savedExperience.getId());
        assertEquals(companyName, savedExperience.getCompanyName());
    }

    @Test
    void saveNoId() {
        String companyName = "experience 2";
        Experience savedExperience = experienceMapService.save(Experience.builder().companyName(companyName).build());

        assertNotNull(savedExperience);
        assertNotNull(savedExperience.getId());
        assertEquals(companyName, savedExperience.getCompanyName());
    }

    @Test
    void delete() {
        experienceMapService.delete(experience);

        assertEquals(0, experienceMapService.findAll().size());
    }

    @Test
    void deleteById() {
        experienceMapService.deleteById(experienceId);

        assertEquals(0, experienceMapService.findAll().size());
    }
}