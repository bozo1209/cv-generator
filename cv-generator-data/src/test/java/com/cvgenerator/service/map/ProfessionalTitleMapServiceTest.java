package com.cvgenerator.service.map;

import com.cvgenerator.model.ProfessionalTitle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionalTitleMapServiceTest {

    ProfessionalTitleMapService professionalTitleMapService;
    ProfessionalTitle professionalTitle;
    Long professionalTitleId = 1L;

    @BeforeEach
    void setUp() {
        professionalTitleMapService = new ProfessionalTitleMapService();

        professionalTitle = ProfessionalTitle.builder().id(professionalTitleId).title("professional title 1").build();

        professionalTitleMapService.save(professionalTitle);
    }

    @Test
    void findAll() {
        Set<ProfessionalTitle> professionalTitles = professionalTitleMapService.findAll();

        assertEquals(1, professionalTitles.size());
    }

    @Test
    void findById() {
        ProfessionalTitle foundProfessionalTitle = professionalTitleMapService.findById(professionalTitleId);

        assertEquals(professionalTitleId, foundProfessionalTitle.getId());
        assertEquals(professionalTitle.getTitle(), foundProfessionalTitle.getTitle());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String titleText = "professional title 2";
        ProfessionalTitle savedProfessionalTitle = professionalTitleMapService.save(ProfessionalTitle.builder().id(id).title(titleText).build());

        assertNotNull(savedProfessionalTitle);
        assertEquals(id, savedProfessionalTitle.getId());
        assertEquals(titleText, savedProfessionalTitle.getTitle());
    }

    @Test
    void saveNoId() {
        String titleText = "professional title 2";
        ProfessionalTitle savedProfessionalTitle = professionalTitleMapService.save(ProfessionalTitle.builder().title(titleText).build());

        assertNotNull(savedProfessionalTitle);
        assertNotNull(savedProfessionalTitle.getId());
        assertEquals(titleText, savedProfessionalTitle.getTitle());
    }

    @Test
    void saveProfessionalTitleNull(){
        assertThrows(RuntimeException.class, () -> professionalTitleMapService.save(null));
    }

    @Test
    void delete() {
        professionalTitleMapService.delete(professionalTitle);

        assertEquals(0, professionalTitleMapService.findAll().size());
    }

    @Test
    void deleteById() {
        professionalTitleMapService.deleteById(professionalTitleId);

        assertEquals(0, professionalTitleMapService.findAll().size());
    }
}