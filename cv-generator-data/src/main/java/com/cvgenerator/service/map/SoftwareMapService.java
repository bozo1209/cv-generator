package com.cvgenerator.service.map;

import com.cvgenerator.model.Software;
import com.cvgenerator.service.SoftwareService;

import java.util.Set;

public class SoftwareMapService extends AbstractMapService<Software, Long> implements SoftwareService {

    @Override
    public Set<Software> findAll() {
        return super.findAll();
    }

    @Override
    public Software findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Software save(Software object) {
        return super.save(object);
    }

    @Override
    public void delete(Software object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
