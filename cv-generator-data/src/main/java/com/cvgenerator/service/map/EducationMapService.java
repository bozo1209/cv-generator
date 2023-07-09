package com.cvgenerator.service.map;

import com.cvgenerator.model.Education;
import com.cvgenerator.service.EducationService;

import java.util.Set;

public class EducationMapService extends AbstractMapService<Education, Long> implements EducationService {

    @Override
    public Set<Education> findAll() {
        return super.findAll();
    }

    @Override
    public Education findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Education save(Education object) {
        return super.save(object);
    }

    @Override
    public void delete(Education object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
