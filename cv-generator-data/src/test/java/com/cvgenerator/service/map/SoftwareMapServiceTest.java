package com.cvgenerator.service.map;

import com.cvgenerator.model.Software;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareMapServiceTest {

    SoftwareMapService softwareMapService;
    Software software;
    Long softwareId = 1L;

    @BeforeEach
    void setUp() {
        softwareMapService = new SoftwareMapService();

        software = Software.builder().id(softwareId).name("software 1").build();

        softwareMapService.save(software);
    }

    @Test
    void findAll() {
        Set<Software> softwares = softwareMapService.findAll();

        assertEquals(1, softwares.size());
    }

    @Test
    void findById() {
        Software foundSoftware = softwareMapService.findById(softwareId);

        assertEquals(softwareId, foundSoftware.getId());
        assertEquals(software.getName(), foundSoftware.getName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String softwareName = "software 2";
        Software savedSoftware = softwareMapService.save(Software.builder().id(id).name(softwareName).build());

        assertNotNull(savedSoftware);
        assertEquals(id, savedSoftware.getId());
        assertEquals(softwareName, savedSoftware.getName());
    }

    @Test
    void saveNoId() {
        String softwareName = "software 2";
        Software savedSoftware = softwareMapService.save(Software.builder().name(softwareName).build());

        assertNotNull(savedSoftware);
        assertNotNull(savedSoftware.getId());
        assertEquals(softwareName, savedSoftware.getName());
    }

    @Test
    void saveSoftwareNull(){
        assertThrows(RuntimeException.class, () -> softwareMapService.save(null));
    }

    @Test
    void delete() {
        softwareMapService.delete(software);

        assertEquals(0, softwareMapService.findAll().size());
    }

    @Test
    void deleteById() {
        softwareMapService.deleteById(softwareId);

        assertEquals(0, softwareMapService.findAll().size());
    }
}