package com.cvgenerator.service.map;

import com.cvgenerator.model.Clause;
import com.cvgenerator.service.ClauseService;

import java.util.Set;

public class ClauseMapService extends AbstractMapService<Clause, Long> implements ClauseService {

    @Override
    public Set<Clause> findAll() {
        return super.findAll();
    }

    @Override
    public Clause findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Clause save(Clause object) {
        return super.save(object);
    }

    @Override
    public void delete(Clause object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
