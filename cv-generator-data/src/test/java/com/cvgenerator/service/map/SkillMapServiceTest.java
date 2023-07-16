package com.cvgenerator.service.map;

import com.cvgenerator.model.Skill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SkillMapServiceTest {

    SkillMapService skillMapService;
    Skill skill;
    Long skillId = 1L;

    @BeforeEach
    void setUp() {
        skillMapService = new SkillMapService();

        skill = Skill.builder().id(skillId).name("skill 1").build();

        skillMapService.save(skill);
    }

    @Test
    void findAll() {
        Set<Skill> skills = skillMapService.findAll();

        assertEquals(1, skills.size());
    }

    @Test
    void findById() {
        Skill foundSkill = skillMapService.findById(skillId);

        assertEquals(skillId, foundSkill.getId());
        assertEquals(skill.getName(), foundSkill.getName());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String skillName = "skill 2";
        Skill savedSkill = skillMapService.save(Skill.builder().id(id).name(skillName).build());

        assertNotNull(savedSkill);
        assertEquals(id, savedSkill.getId());
        assertEquals(skillName, savedSkill.getName());
    }

    @Test
    void saveNoId() {
        String skillName = "skill 2";
        Skill savedSkill = skillMapService.save(Skill.builder().name(skillName).build());

        assertNotNull(savedSkill);
        assertNotNull(savedSkill.getId());
        assertEquals(skillName, savedSkill.getName());
    }

    @Test
    void delete() {
        skillMapService.delete(skill);

        assertEquals(0, skillMapService.findAll().size());
    }

    @Test
    void deleteById() {
        skillMapService.deleteById(skillId);

        assertEquals(0, skillMapService.findAll().size());
    }
}