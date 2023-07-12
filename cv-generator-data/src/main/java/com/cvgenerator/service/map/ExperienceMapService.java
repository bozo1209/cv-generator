package com.cvgenerator.service.map;

import com.cvgenerator.model.Experience;
import com.cvgenerator.service.ExperienceService;

import java.util.Set;

public class ExperienceMapService extends AbstractMapService<Experience, Long> implements ExperienceService {

    @Override
    public Set<Experience> findAll() {
        return super.findAll();
    }

    @Override
    public Experience findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Experience save(Experience object) {
        return super.save(object);
    }

    @Override
    public void delete(Experience object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
