package com.cvgenerator.service.map;

import com.cvgenerator.model.ProfessionalTitle;
import com.cvgenerator.service.ProfessionalTitleService;

import java.util.Set;

public class ProfessionalTitleMapService extends AbstractMapService<ProfessionalTitle, Long> implements ProfessionalTitleService {

    @Override
    public Set<ProfessionalTitle> findAll() {
        return super.findAll();
    }

    @Override
    public ProfessionalTitle findById(Long id) {
        return super.findById(id);
    }

    @Override
    public ProfessionalTitle save(ProfessionalTitle object) {
        return super.save(object);
    }

    @Override
    public void delete(ProfessionalTitle object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
