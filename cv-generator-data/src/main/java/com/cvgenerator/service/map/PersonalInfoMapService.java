package com.cvgenerator.service.map;

import com.cvgenerator.model.PersonalInfo;
import com.cvgenerator.service.PersonalInfoService;

import java.util.Set;

public class PersonalInfoMapService extends AbstractMapService<PersonalInfo, Long> implements PersonalInfoService {

    @Override
    public Set<PersonalInfo> findAll() {
        return super.findAll();
    }

    @Override
    public PersonalInfo findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PersonalInfo save(PersonalInfo object) {
        return super.save(object);
    }

    @Override
    public void delete(PersonalInfo object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
