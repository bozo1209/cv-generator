package com.cvgenerator.service.map;

import com.cvgenerator.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LanguageMapServiceTest {

    LanguageMapService languageMapService;
    Language language;
    Long languageId = 1L;

    @BeforeEach
    void setUp() {
        languageMapService = new LanguageMapService();

        language = Language.builder().id(languageId).name("language 1").build();

        languageMapService.save(language);
    }

    @Test
    void findAll() {
        Set<Language> languages = languageMapService.findAll();

        assertEquals(1, languages.size());
    }

    @Test
    void findById() {
        Language foundLanguage = languageMapService.findById(languageId);

        assertEquals(languageId, foundLanguage.getId());
        assertEquals(language.getName(), foundLanguage.getName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String languageName = "language 2";
        Language savedLanguage = languageMapService.save(Language.builder().id(id).name(languageName).build());

        assertNotNull(savedLanguage);
        assertEquals(id, savedLanguage.getId());
        assertEquals(languageName, savedLanguage.getName());
    }

    @Test
    void saveNoId() {
        String languageName = "language 2";
        Language savedLanguage = languageMapService.save(Language.builder().name(languageName).build());

        assertNotNull(savedLanguage);
        assertNotNull(savedLanguage.getId());
        assertEquals(languageName, savedLanguage.getName());
    }

    @Test
    void saveLanguageNull(){
        assertThrows(RuntimeException.class, () -> languageMapService.save(null));
    }

    @Test
    void delete() {
        languageMapService.delete(language);

        assertEquals(0, languageMapService.findAll().size());
    }

    @Test
    void deleteById() {
        languageMapService.deleteById(languageId);

        assertEquals(0, languageMapService.findAll().size());
    }
}