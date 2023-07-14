package com.cvgenerator.service.map;

import com.cvgenerator.model.PersonalInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PersonalInfoMapServiceTest {

    PersonalInfoMapService personalInfoMapService;
    PersonalInfo personalInfo;
    Long personalInfoId = 1L;

    @BeforeEach
    void setUp() {
        personalInfoMapService = new PersonalInfoMapService();

        personalInfo = PersonalInfo.builder().id(personalInfoId).firstName("personal info 1").build();

        personalInfoMapService.save(personalInfo);
    }

    @Test
    void findAll() {
        Set<PersonalInfo> personalInfos = personalInfoMapService.findAll();

        assertEquals(1, personalInfos.size());
    }

    @Test
    void findById() {
        PersonalInfo foundPersonalInfo = personalInfoMapService.findById(personalInfoId);

        assertEquals(personalInfoId, foundPersonalInfo.getId());
        assertEquals(personalInfo.getFirstName(), foundPersonalInfo.getFirstName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String personalInfoFirstName = "personal info 2";
        PersonalInfo savedPersonalInfo = personalInfoMapService.save(PersonalInfo.builder().id(id).firstName(personalInfoFirstName).build());

        assertNotNull(savedPersonalInfo);
        assertEquals(id, savedPersonalInfo.getId());
        assertEquals(personalInfoFirstName, savedPersonalInfo.getFirstName());
    }

    @Test
    void saveNoId() {
        String personalInfoFirstName = "personal info 2";
        PersonalInfo savedPersonalInfo = personalInfoMapService.save(PersonalInfo.builder().firstName(personalInfoFirstName).build());

        assertNotNull(savedPersonalInfo);
        assertNotNull(savedPersonalInfo.getId());
        assertEquals(personalInfoFirstName, savedPersonalInfo.getFirstName());
    }

    @Test
    void delete() {
        personalInfoMapService.delete(personalInfo);

        assertEquals(0, personalInfoMapService.findAll().size());
    }

    @Test
    void deleteById() {
        personalInfoMapService.deleteById(personalInfoId);

        assertEquals(0, personalInfoMapService.findAll().size());
    }
}