package com.cvgenerator.service.map;

import com.cvgenerator.model.Language;
import com.cvgenerator.service.LanguageService;

import java.util.Set;

public class LanguageMapService extends AbstractMapService<Language, Long> implements LanguageService {

    @Override
    public Set<Language> findAll() {
        return super.findAll();
    }

    @Override
    public Language findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Language save(Language object) {
        return super.save(object);
    }

    @Override
    public void delete(Language object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
