package com.cvgenerator.service.map;

import com.cvgenerator.model.ProfessionalSummary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionalSummaryMapServiceTest {

    ProfessionalSummaryMapService professionalSummaryMapService;
    ProfessionalSummary professionalSummary;
    Long professionalSummaryId = 1L;

    @BeforeEach
    void setUp() {
        professionalSummaryMapService = new ProfessionalSummaryMapService();

        professionalSummary = ProfessionalSummary.builder().id(professionalSummaryId).summary("professional summary 1").build();

        professionalSummaryMapService.save(professionalSummary);
    }

    @Test
    void findAll() {
        Set<ProfessionalSummary> professionalSummaries = professionalSummaryMapService.findAll();

        assertEquals(1, professionalSummaries.size());
    }

    @Test
    void findById() {
        ProfessionalSummary foundProfessionalSummary = professionalSummaryMapService.findById(professionalSummaryId);

        assertEquals(professionalSummaryId, foundProfessionalSummary.getId());
        assertEquals(professionalSummary.getSummary(), foundProfessionalSummary.getSummary());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String summaryText = "professional summary 2";
        ProfessionalSummary savedProfessionalSummary = professionalSummaryMapService.save(ProfessionalSummary.builder().id(id).summary(summaryText).build());

        assertNotNull(savedProfessionalSummary);
        assertEquals(id, savedProfessionalSummary.getId());
        assertEquals(summaryText, savedProfessionalSummary.getSummary());
    }

    @Test
    void saveNoId() {
        String summaryText = "professional summary 2";
        ProfessionalSummary savedProfessionalSummary = professionalSummaryMapService.save(ProfessionalSummary.builder().summary(summaryText).build());

        assertNotNull(savedProfessionalSummary);
        assertNotNull(savedProfessionalSummary.getId());
        assertEquals(summaryText, savedProfessionalSummary.getSummary());
    }

    @Test
    void saveProfessionalSummaryNull(){
        assertThrows(RuntimeException.class, () -> professionalSummaryMapService.save(null));
    }

    @Test
    void delete() {
        professionalSummaryMapService.delete(professionalSummary);

        assertEquals(0, professionalSummaryMapService.findAll().size());
    }

    @Test
    void deleteById() {
        professionalSummaryMapService.deleteById(professionalSummaryId);

        assertEquals(0, professionalSummaryMapService.findAll().size());
    }
}