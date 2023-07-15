package com.cvgenerator.service.map;

import com.cvgenerator.model.ProfessionalSummary;
import com.cvgenerator.service.ProfessionalSummaryService;

import java.util.Set;

public class ProfessionalSummaryMapService extends AbstractMapService<ProfessionalSummary, Long> implements ProfessionalSummaryService {

    @Override
    public Set<ProfessionalSummary> findAll() {
        return super.findAll();
    }

    @Override
    public ProfessionalSummary findById(Long id) {
        return super.findById(id);
    }

    @Override
    public ProfessionalSummary save(ProfessionalSummary object) {
        return super.save(object);
    }

    @Override
    public void delete(ProfessionalSummary object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
