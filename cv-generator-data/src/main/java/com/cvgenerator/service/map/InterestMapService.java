package com.cvgenerator.service.map;

import com.cvgenerator.model.Interest;
import com.cvgenerator.service.InterestService;

import java.util.Set;

public class InterestMapService extends AbstractMapService<Interest, Long> implements InterestService {

    @Override
    public Set<Interest> findAll() {
        return super.findAll();
    }

    @Override
    public Interest findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Interest save(Interest object) {
        return super.save(object);
    }

    @Override
    public void delete(Interest object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
