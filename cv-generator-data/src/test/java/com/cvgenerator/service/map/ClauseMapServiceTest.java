package com.cvgenerator.service.map;

import com.cvgenerator.model.Clause;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClauseMapServiceTest {

    ClauseMapService clauseMapService;
    Clause clause;
    Long clauseId = 1L;

    @BeforeEach
    void setUp() {
        clauseMapService = new ClauseMapService();

        clause = Clause.builder().id(clauseId).clause("clause 1").build();

        clauseMapService.save(clause);
    }

    @Test
    void findAll() {
        Set<Clause> clauses = clauseMapService.findAll();

        assertEquals(1, clauses.size());
    }

    @Test
    void findById() {
        Clause foundClause = clauseMapService.findById(clause.getId());

        assertEquals(clauseId, foundClause.getId());
        assertEquals(clause.getClause(), foundClause.getClause());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        String clauseText = "clause 2";
        Clause savedClause = clauseMapService.save(Clause.builder().id(id).clause(clauseText).build());

        assertNotNull(savedClause);
        assertEquals(id, savedClause.getId());
        assertEquals(clauseText, savedClause.getClause());
    }

    @Test
    void saveNoId() {
        String clauseText = "clause 3";
        Clause savedClause = clauseMapService.save(Clause.builder().clause(clauseText).build());

        assertNotNull(savedClause);
        assertNotNull(savedClause.getId());
        assertEquals(clauseText, savedClause.getClause());
    }

    @Test
    void saveClauseNull(){
        assertThrows(RuntimeException.class, () -> clauseMapService.save(null));
    }

    @Test
    void delete() {
        clauseMapService.delete(clause);

        assertEquals(0, clauseMapService.findAll().size());
    }

    @Test
    void deleteById() {
        clauseMapService.deleteById(clauseId);

        assertEquals(0, clauseMapService.findAll().size());
    }
}