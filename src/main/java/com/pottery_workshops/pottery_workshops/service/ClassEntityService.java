package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.ClassEntity;
import com.pottery_workshops.pottery_workshops.repository.ClassEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEntityService {
    @Autowired
    private ClassEntityRepository classEntityRepository;

    public List<ClassEntity> findAll() {
        return classEntityRepository.findAll();
    }

    public ClassEntity save(ClassEntity classEntity) {
        return classEntityRepository.save(classEntity);
    }
}
