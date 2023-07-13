package com.cvgenerator.service.map;

import com.cvgenerator.model.Interest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InterestMapServiceTest {

    InterestMapService interestMapService;
    Interest interest;
    Long interestId = 1L;

    @BeforeEach
    void setUp() {
        interestMapService = new InterestMapService();

        interest = Interest.builder().id(interestId).name("interest 1").build();

        interestMapService.save(interest);
    }

    @Test
    void findAll() {
        Set<Interest> interests = interestMapService.findAll();

        assertEquals(1, interests.size());
    }

    @Test
    void findById() {
        Interest foundInterest = interestMapService.findById(interestId);

        assertEquals(interestId, foundInterest.getId());
        assertEquals(interest.getName(), foundInterest.getName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String interestName = "interest 2";
        Interest savedInterest = interestMapService.save(Interest.builder().id(id).name(interestName).build());

        assertNotNull(savedInterest);
        assertEquals(id, savedInterest.getId());
        assertEquals(interestName, savedInterest.getName());
    }

    @Test
    void saveNoId() {
        String interestName = "interest 2";
        Interest savedInterest = interestMapService.save(Interest.builder().name(interestName).build());

        assertNotNull(savedInterest);
        assertNotNull(savedInterest.getId());
        assertEquals(interestName, savedInterest.getName());
    }

    @Test
    void delete() {
        interestMapService.delete(interest);

        assertEquals(0, interestMapService.findAll().size());
    }

    @Test
    void deleteById() {
        interestMapService.deleteById(interestId);

        assertEquals(0, interestMapService.findAll().size());

    }
}