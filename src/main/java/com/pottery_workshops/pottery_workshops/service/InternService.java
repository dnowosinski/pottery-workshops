package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.Intern;
import com.pottery_workshops.pottery_workshops.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternService {
    @Autowired
    private InternRepository internRepository;

    public List<Intern> findAll() {
        return internRepository.findAll();
    }

    public Intern save(Intern intern) {
        return internRepository.save(intern);
    }
}