package com.cvgenerator.service.map;

import com.cvgenerator.model.BaseEntity;
import com.cvgenerator.service.CRUDService;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> implements CRUDService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        Optional.ofNullable(object).ifPresentOrElse(obj -> {
            if (obj.getId() == null){
                obj.setId(getNextId());
            }
            map.put(obj.getId(), obj);
        }, () -> {
            throw new RuntimeException("object cannot be null");
        });
        return object;
    }

    @Override
    public void delete(T object) {
        map.remove(object.getId());
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId(){
        Set<Long> keySet = map.keySet();
        return keySet.size() == 0 ? 1L : Collections.max(keySet) + 1L;
    }

}
