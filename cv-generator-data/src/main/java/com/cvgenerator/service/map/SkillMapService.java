package com.cvgenerator.service.map;

import com.cvgenerator.model.Skill;
import com.cvgenerator.service.SkillService;

import java.util.Set;

public class SkillMapService extends AbstractMapService<Skill, Long> implements SkillService {

    @Override
    public Set<Skill> findAll() {
        return super.findAll();
    }

    @Override
    public Skill findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Skill save(Skill object) {
        return super.save(object);
    }

    @Override
    public void delete(Skill object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
